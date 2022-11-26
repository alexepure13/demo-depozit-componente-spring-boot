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

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/addCategory")
    public String addCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @PostMapping("/editCategory")
    public String editCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable(name = "id") Long id) throws Exception {
        ModelAndView editCategoryView = new ModelAndView("CategoryFormEdit");
        Category category = categoryService.getCategoryById(id);
        editCategoryView.addObject("category", category);
        return editCategoryView;
    }


    @RequestMapping(path="/deleteCategory/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id)
    {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
