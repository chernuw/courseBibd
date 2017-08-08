package com.chernuw.controller;

import com.chernuw.service.interfaces.CartService;
import com.chernuw.service.interfaces.ManufacturerService;
import com.chernuw.service.interfaces.FootwearService;
import com.chernuw.service.interfaces.FootwearTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.chernuw.service")
public class FootwearPageController {

    private final ManufacturerService manufacturerService;

    private final FootwearService footwearService;

    private final FootwearTypeService footwearTypeService;

    private final CartService cartService;

    @Autowired
    public FootwearPageController(final ManufacturerService manufacturerService, final FootwearService footwearService, final FootwearTypeService footwearTypeService, final CartService cartService) {
        this.manufacturerService = manufacturerService;
        this.footwearService = footwearService;
        this.footwearTypeService = footwearTypeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @ModelAttribute
    public void leftMenu(Model model) {
        model.addAttribute("footweartypes", footwearTypeService.getAllFootwearTypes());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
    }

    @RequestMapping(value="/footwear-details/{id}", method = RequestMethod.GET)
    public ModelAndView viewFootwearInfo(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("product-details");
        modelAndView.addObject("footwear", footwearService.getFootwearById(id));
        modelAndView.addObject("recommendedFootwears1", footwearService.getAllFootwear(1, 3));
        modelAndView.addObject("recommendedFootwears2", footwearService.getAllFootwear(2, 3));
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