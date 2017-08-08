package com.chernuw.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.chernuw.service")
public class AdminCategoryController {

    @RequestMapping("/admin/category")
    public ModelAndView viewAdminCategoryPage() {
        return new ModelAndView("admin/category");
    }
}
