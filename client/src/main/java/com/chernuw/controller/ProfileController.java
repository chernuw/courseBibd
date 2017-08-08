package com.chernuw.controller;

import com.chernuw.model.User;
import com.chernuw.service.interfaces.CartService;
import com.chernuw.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
@ComponentScan(basePackages="com.chernuw.service")
public class ProfileController {

    private final CartService cartService;

    private final UserService userService;

    @Autowired
    public ProfileController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @ModelAttribute("userUpd")
    public User createOrderModel(String user) {
        return userService.findByUsername(user);
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profilePage() {
        ModelAndView modelAndView = new ModelAndView("profile/index");
//        modelAndView.addObject("user", userService.findByUsername(userName));
        return new ModelAndView("profile/index");
    }

//    TODO:доделать страницу обновления профиля
    @RequestMapping(value = "/profile/edit/{user}", method = RequestMethod.GET)
    public ModelAndView profileEditPage(@PathVariable("user") final String user) {
        ModelAndView modelAndView = new ModelAndView("profile/edit");
        modelAndView.addObject("userEdit", userService.findByUsername(user));
        return modelAndView;
    }

    @RequestMapping(value = "/profile/editProfile", method = RequestMethod.POST)
    public ModelAndView profileEditUpdatePage(@Validated User user, BindingResult bindingResult) throws Exception{
        System.out.print("Q!!!QWEQWDSA");
        if(bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/profile/edit/"+user.getName());
        }
//        userService.updateUser(userService.findById(user.getId()));
//        user.setEmail(user.getEmail());
        return new ModelAndView("redirect:/profile/edit/"+user.getName());
    }

//    TODO:сделать страницу историй заказов
    @RequestMapping(value = "/profile/history", method = RequestMethod.GET)
    public ModelAndView profileHistoryPage(@PathVariable("user") final String user) {
        return new ModelAndView("profile/history");
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
