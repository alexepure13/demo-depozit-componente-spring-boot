package com.example.Depozit.de.componente.PC.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long id;
    private int category_code;
    private String typeOfComponent;
    private int quantity;
}
