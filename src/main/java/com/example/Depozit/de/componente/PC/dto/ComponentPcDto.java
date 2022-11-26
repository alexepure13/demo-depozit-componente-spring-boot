package com.example.Depozit.de.componente.PC.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentPcDto {

    private Long id;
    private int product_code;
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private CategoryDto category;
}
