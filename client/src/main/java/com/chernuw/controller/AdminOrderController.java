package com.chernuw.controller;

import com.chernuw.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
@ComponentScan(basePackages = "com.chernuw.service")
public class AdminOrderController {

    @Autowired
    private StatusService statusService;

    @Autowired
    private OrderService orderService;

    private final CartService cartService;

    private final FootwearService footwearService;

    private final SaleService saleService;

    private final UserService userService;

    @Autowired
    public AdminOrderController(CartService cartService, FootwearService footwearService, SaleService saleService, UserService userService) {
        this.cartService = cartService;
        this.footwearService = footwearService;
        this.saleService = saleService;
        this.userService = userService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @ModelAttribute
    public void viewAllOrders(Model model) {
        model.addAttribute("statuses", statusService.getStatuses());
        model.addAttribute("order", orderService.getAllOrders());
    }

    @RequestMapping("/admin/order")
    public ModelAndView viewAllOrders() {
        return new ModelAndView("admin_order/index");
    }

    @RequestMapping(value = "/admin/order/changeStatus", method = RequestMethod.POST)
    public ModelAndView changeStatus(@RequestParam("id") final int id, @RequestParam("changedStatus") final String status) throws UnsupportedEncodingException {
        orderService.updateStatus(id, status);
        return new ModelAndView("redirect:/admin/order");
    }

    @RequestMapping(value="/admin/order/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewOrderInfo(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("admin_order/view");
        modelAndView.addObject("order", orderService.getOrderById(id));
        modelAndView.addObject("sales", saleService.getSalesByOrderId(id));
        return modelAndView;
    }

    @RequestMapping(value="/admin/order/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable("id") final int id) {
        orderService.deleteOrder(orderService.getOrderById(id));
        return new ModelAndView("redirect:/admin/order");
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
