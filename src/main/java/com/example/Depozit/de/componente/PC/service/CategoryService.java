package com.example.Depozit.de.componente.PC.service;

import com.example.Depozit.de.componente.PC.dto.CategoryDto;
import com.example.Depozit.de.componente.PC.entity.Category;
import com.example.Depozit.de.componente.PC.mapper.CateogryMapper;
import com.example.Depozit.de.componente.PC.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CateogryMapper cateogryMapper;

    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream().map(e -> cateogryMapper.mapCategoryDto(e)).collect(Collectors.toList());
    }


    public Category getCategoryById(Long id) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) return category.get();
        else {
            throw new Exception("Exceptie");
        }
    }

    public void saveCategory(CategoryDto categoryDto) {
        Category category = cateogryMapper.mapCategory(categoryDto);
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
