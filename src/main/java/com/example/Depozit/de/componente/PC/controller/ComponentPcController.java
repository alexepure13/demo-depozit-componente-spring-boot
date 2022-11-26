package com.example.Depozit.de.componente.PC.controller;

import com.example.Depozit.de.componente.PC.dto.CategoryDto;
import com.example.Depozit.de.componente.PC.dto.ComponentPcDto;
import com.example.Depozit.de.componente.PC.entity.ComponentPc;
import com.example.Depozit.de.componente.PC.service.CategoryService;
import com.example.Depozit.de.componente.PC.service.ComponentPcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ComponentPcController {

    @Autowired
    ComponentPcService componentPcService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/editComponent/{id}")
    public ModelAndView showEditToyPage(Model model, @PathVariable(name = "id") Long id) throws Exception {
        ModelAndView editCategoryView = new ModelAndView("ComponentFormEdit");
        ComponentPc component = componentPcService.getComponentById(id);
        List<CategoryDto> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        editCategoryView.addObject("component", component);
        return editCategoryView;
    }

    @PostMapping(value = "/addComponent")
    public String addComponent(@ModelAttribute ComponentPcDto componentPcDto){
        componentPcService.saveComponent(componentPcDto);
        return "redirect:/components";
    }

    @RequestMapping(path="/deleteComponent/{id}")
    public String deleteComponentById(@PathVariable("id") Long id)
    {
        componentPcService.deleteComponentById(id);
        return "redirect:/components";
    }

}
