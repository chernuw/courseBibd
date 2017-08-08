package com.chernuw.controller;

import com.chernuw.service.interfaces.CartService;
import com.chernuw.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@ComponentScan(basePackages = "com.chernuw.service")
public class AdminController {

    private final CartService cartService;

    private final UserService userService;

    @Autowired
    public AdminController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @RequestMapping("/admin")
    public ModelAndView viewAdminPage() {
        return new ModelAndView("admin");
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
