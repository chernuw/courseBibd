package com.chernuw.controller;

import com.chernuw.model.Footwear;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@ComponentScan(basePackages = "com.chernuw.service")
public class HomeController {

    private final ManufacturerService manufacturerService;

    private final FootwearService footwearService;

    private final FootwearTypeService footwearTypeService;

    private final CartService cartService;

    @Autowired
    public HomeController(final ManufacturerService manufacturerService, final FootwearService footwearService, final FootwearTypeService footwearTypeService, final CartService cartService) {
        this.manufacturerService = manufacturerService;
        this.footwearService = footwearService;
        this.footwearTypeService = footwearTypeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("footweartypes", footwearTypeService.getAllFootwearTypes());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
        model.addAttribute("user", getPrincipal());
    }

    @RequestMapping(value = {"", "/", "/index", "/home"}, method = RequestMethod.GET)
    public ModelAndView viewAllFootwearsOnFirstPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getAllFootwear(1, 9);
        int amountOfFootwear = footwearService.getAllFootwear().size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/home/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/home/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewAllFootwearsOnSpecificPage(@PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getAllFootwear(numberOfPage, 9);
        int amountOfFootwear = footwearService.getAllFootwear().size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/home/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public void showImage(@PathVariable("id") final int id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(footwearService.getFootwearById(id).getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/footwearType/{id}", method = RequestMethod.GET)
    public ModelAndView viewSpecificFootwearTypeFootwearsOnFirstPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getFootwearsByFootwearType(id, 1, 9);
        int amountOfFootwear = footwearService.getFootwearsByFootwearType(id).size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/footwearType/" + id + "/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/footwearType/{id}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewSpecificFootwearTypeFootwearsOnSpecificPage(@PathVariable("id") final int id, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getFootwearsByFootwearType(id, numberOfPage, 9);
        int amountOfFootwear = footwearService.getFootwearsByFootwearType(id).size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/footwearType/" + id + "/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/manufacturer/{id}", method = RequestMethod.GET)
    public ModelAndView viewSpecificManufacturerFootwearsOnFirstPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getFootwearsByManufacturer(id, 1, 9);
        int amountOfFootwear = footwearService.getFootwearsByManufacturer(id).size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/manufacturer/" + id + "/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/manufacturer/{id}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewSpecificManufacturerFootwearsOnSpecificPage(@PathVariable("id") final int id, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getFootwearsByManufacturer(id, numberOfPage, 9);
        int amountOfFootwear = footwearService.getFootwearsByManufacturer(id).size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/manufacturer/" + id + "/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchFootwears(@RequestParam("searchValue") final String searchValue) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getFootwearsBySearch(new String (searchValue.getBytes ("iso-8859-1"), "UTF-8"), 1, 9);
        int amountOfFootwear = footwearService.getFootwearsBySearch(new String (searchValue.getBytes ("iso-8859-1"), "UTF-8")).size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/search/");
        modelAndView.addObject("openedPage", 1);
        modelAndView.addObject("searchValue", new String (searchValue.getBytes ("iso-8859-1"), "UTF-8"));
        return modelAndView;
    }

    @RequestMapping(value = "/search/{searchValue}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView searchFootwears(@PathVariable("searchValue") final String searchValue, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Footwear> footwearList = footwearService.getFootwearsBySearch(searchValue, numberOfPage, 9);
        int amountOfFootwear = footwearService.getFootwearsBySearch(searchValue).size();
        modelAndView.addObject("footwears", footwearList);
        modelAndView.addObject("amountOfPages", (amountOfFootwear % 9 == 0) ? (amountOfFootwear / 9) : (amountOfFootwear / 9 + 1));
        modelAndView.addObject("url", "/search/");
        modelAndView.addObject("openedPage", numberOfPage);
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
