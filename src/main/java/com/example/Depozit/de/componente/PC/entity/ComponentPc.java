package com.example.Depozit.de.componente.PC.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_COMPONENT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ComponentPc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_code")
    private int product_code;
    @Column(name="name")
    private String name;
    @Column(name="manufacturer")
    private String manufacturer;
    @Column(name="price")
    private double price;
    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category = new Category();

}
