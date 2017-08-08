package com.chernuw.controller;

import com.chernuw.model.User;
import com.chernuw.model.UserType;
import com.chernuw.service.interfaces.CartService;
import com.chernuw.service.interfaces.UserService;
import com.chernuw.service.interfaces.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@ComponentScan(basePackages = "com.chernuw.service")
public class LoginController {

    private final CartService cartService;
    private final UserService userService;
    private final UserTypeService userTypeService;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validator);
    }

    @ModelAttribute("userReg")
    public User createOrderModel() {
        return new User();
    }

    @Autowired
    public LoginController(CartService cartService, UserService userService, UserTypeService userTypeService) {
        this.cartService = cartService;
        this.userService = userService;
        this.userTypeService = userTypeService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }


    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("userReg") @Validated User user, BindingResult bindingResult) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        if(bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }
        user.setName(new String (user.getName().getBytes("iso-8859-1"), "UTF-8"));
        user.setSurname(new String (user.getSurname().getBytes("iso-8859-1"), "UTF-8"));
        int idOfUser = userService.saveUser(user);
        UserType userType = new UserType();
        userType.setUser_id(idOfUser);
        userType.setRole_id(1);
        userTypeService.save(userType);
        modelAndView.addObject("registerMessage", "Вы успешно зарегистрировались");
        return modelAndView;
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
