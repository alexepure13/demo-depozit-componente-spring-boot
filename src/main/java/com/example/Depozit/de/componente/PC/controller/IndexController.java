package com.example.Depozit.de.componente.PC.controller;

import com.example.Depozit.de.componente.PC.dto.CategoryDto;
import com.example.Depozit.de.componente.PC.entity.Category;
import com.example.Depozit.de.componente.PC.service.CategoryService;
import com.example.Depozit.de.componente.PC.service.ComponentPcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ComponentPcService componentPcService;

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/index")
    public ModelAndView openIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @GetMapping(value = "/components")
    public ModelAndView openComponents(Model model){
        ModelAndView mav = new ModelAndView();
        model.addAttribute("components", componentPcService.getComponents());
        mav.setViewName("components");
        return mav;
    }

    @GetMapping(value = "/categories")
    public ModelAndView openCategories(Model model){
        ModelAndView mav = new ModelAndView();
        model.addAttribute("categories", categoryService.getCategories());
        mav.setViewName("categories");
        return mav;
    }

    @GetMapping(value="/CategoryForm")
    public ModelAndView openCategoryForm(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("CategoryForm");
        return mav;
    }

    @GetMapping(value = "/ComponentForm")
    public ModelAndView openComponentForm(Model model) {
        ModelAndView mav = new ModelAndView();
        List<CategoryDto> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        mav.setViewName("ComponentForm");
        return mav;
    }
}
