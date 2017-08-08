package com.chernuw.controller;

import com.chernuw.model.Footwear;
import com.chernuw.service.interfaces.*;
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
@ComponentScan(basePackages = "com.chernuw.service")
public class AdminProductController {

    /*@ModelAttribute("updateProd")
    public Footwear footwearModel() {
        return new Footwear();
        return footwearService.getFootwearById(id);
    }*/

    @ModelAttribute("prodCreate")
    public Footwear createOrderModel() {
        return new Footwear();
    }

    @Autowired
    private final FootwearService footwearService;

    @Autowired
    private final ManufacturerService manufacturerService;

    @Autowired
    private final ProviderService providerService;

    @Autowired
    private final SexService sexService;

    @Autowired
    private final ColorService colorService;

    @Autowired
    private final FixationService fixationService;

    @Autowired
    private final MaterialService materialService;

    @Autowired
    private final FootwearTypeService footwearTypeService;

    private final CartService cartService;


    @Autowired
    public AdminProductController(FootwearService footwearService, ManufacturerService manufacturerService, ProviderService providerService, SexService sexService, ColorService colorService, FixationService fixationService, MaterialService materialService, FootwearTypeService footwearTypeService, CartService cartService) {
        this.footwearService = footwearService;
        this.manufacturerService = manufacturerService;
        this.providerService = providerService;
        this.sexService = sexService;
        this.colorService = colorService;
        this.fixationService = fixationService;
        this.materialService = materialService;
        this.footwearTypeService = footwearTypeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @ModelAttribute
    public void viewAllProducts(Model model){
        model.addAttribute("footwear", footwearService.getAllFootwear());

    }

    @RequestMapping("/admin/product")
    public ModelAndView viewAllProducts() {
        return new ModelAndView("admin_product/index");
    }



    @RequestMapping(value = "/admin/product/create", method = RequestMethod.GET)
    public ModelAndView createProductPage() throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("admin_product/create");
        modelAndView.addObject("manufacturer", manufacturerService.getAllManufacturers());
        modelAndView.addObject("provider", providerService.getAllProviders());
        modelAndView.addObject("sex", sexService.getAllSexs());
        modelAndView.addObject("color", colorService.getAllColors());
        modelAndView.addObject("fixation", fixationService.getAllFixations());
        modelAndView.addObject("material", materialService.getAllMaterials());
        modelAndView.addObject("footwearType", footwearTypeService.getAllFootwearTypes());
        return modelAndView;
//        return new ModelAndView("admin_product/create");
    }

    @RequestMapping(value = "/admin/product/create/createProduct", method = RequestMethod.POST)
    public ModelAndView createProductPage(@ModelAttribute("prodCreate") @Validated Footwear footwear, BindingResult bindingResult) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("admin_product/create");
        if(bindingResult.hasErrors()) {
            return new ModelAndView("admin_product/create");
        }
        /*modelAndView.addObject("manufacturer", manufacturerService.getAllManufacturers());
        modelAndView.addObject("provider", providerService.getAllProviders());
        modelAndView.addObject("sex", sexService.getAllSexs());
        modelAndView.addObject("color", colorService.getAllColors());
        modelAndView.addObject("fixation", fixationService.getAllFixations());
        modelAndView.addObject("material", materialService.getAllMaterials());
        modelAndView.addObject("footwearType", footwearTypeService.getAllFootwearTypes());*/
        footwearService.saveFootwear(footwear);
        return modelAndView;
    }


    @RequestMapping(value = "/admin/product/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateProductPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("admin_product/update");
        modelAndView.addObject("footwear", footwearService.getFootwearById(id));
        modelAndView.addObject("manufacturer", manufacturerService.getAllManufacturers());
        modelAndView.addObject("provider", providerService.getAllProviders());
        modelAndView.addObject("sex", sexService.getAllSexs());
        modelAndView.addObject("color", colorService.getAllColors());
        modelAndView.addObject("fixation", fixationService.getAllFixations());
        modelAndView.addObject("material", materialService.getAllMaterials());
        modelAndView.addObject("footwearType", footwearTypeService.getAllFootwearTypes());
        return modelAndView;
    }

//TODO: доделать обновление товара
//    public String updateProduct(@ModelAttribute("footwear") Footwear footwear, @RequestParam("id") final int id, @RequestParam("changedStatus") final String status) throws UnsupportedEncodingException {
//    public ModelAndView updateProduct(@ModelAttribute("prod") Footwear footwear, @RequestParam("id") final int id, @RequestParam("changedStatus") final String status) throws UnsupportedEncodingException {
//public ModelAndView updateProduct(Footwear footwear, @RequestParam("id") final int id) throws UnsupportedEncodingException {

    @RequestMapping(value = "/admin/product/update/updateProduct", method = RequestMethod.POST)
    public ModelAndView updateFootwear(@PathVariable("id") final int id, @Validated Footwear footwear, BindingResult bindingResult) throws UnsupportedEncodingException {
        System.out.print("!!!!!!!!!!!!AAAAAAAAAAAAAAAAAAA!!");
        if(bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/admin/product/update/{id}");
        }
        footwearService.updateFootwear(footwear);
        return new ModelAndView("redirect:/admin/product/update/{id}");
//        return  "succes update";
    }

    @RequestMapping(value="/admin/product/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("id") final int id) {
        footwearService.deleteFootwear(footwearService.getFootwearById(id));
        return new ModelAndView("redirect:/admin/product");
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
