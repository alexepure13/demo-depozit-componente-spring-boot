package com.example.Depozit.de.componente.PC.mapper;

import com.example.Depozit.de.componente.PC.dto.CategoryDto;
import com.example.Depozit.de.componente.PC.dto.ComponentPcDto;
import com.example.Depozit.de.componente.PC.entity.ComponentPc;
import org.springframework.stereotype.Component;


@Component
public class ComponentMapper {

    public ComponentPcDto mapComponentPcDto(ComponentPc component){
        CategoryDto categoryDto = CategoryDto.builder()
                .id(component.getCategory().getId())
                .category_code(component.getCategory().getCategory_code())
                .typeOfComponent(component.getCategory().getTypeOfComponent())
                .quantity(component.getCategory().getQuantity())
                .build();

        return ComponentPcDto.builder()
                .id(component.getId())
                .product_code(component.getProduct_code())
                .name(component.getName())
                .manufacturer(component.getManufacturer())
                .price(component.getPrice())
                .quantity(component.getQuantity())
                .category(categoryDto)
                .build();
    }

    public ComponentPc mapComponentPc(ComponentPcDto componentPcDto){
        CateogryMapper cateogryMapper = new CateogryMapper();

        return ComponentPc.builder()
                .id(componentPcDto.getId())
                .product_code(componentPcDto.getProduct_code())
                .name(componentPcDto.getName())
                .manufacturer(componentPcDto.getManufacturer())
                .price(componentPcDto.getPrice())
                .quantity(componentPcDto.getQuantity())
                .category(cateogryMapper.mapCategory(componentPcDto.getCategory()))
                .build();
    }
}
