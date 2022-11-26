package com.example.Depozit.de.componente.PC.mapper;

import com.example.Depozit.de.componente.PC.dto.CategoryDto;
import com.example.Depozit.de.componente.PC.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CateogryMapper {

    public CategoryDto mapCategoryDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .category_code(category.getCategory_code())
                .typeOfComponent(category.getTypeOfComponent())
                .quantity(category.getQuantity())
                .build();
    }

    public Category mapCategory(CategoryDto categoryDto){
        return Category.builder()
                .id(categoryDto.getId())
                .category_code(categoryDto.getCategory_code())
                .typeOfComponent(categoryDto.getTypeOfComponent())
                .quantity(categoryDto.getQuantity())
                .build();
    }
}
