package com.example.Depozit.de.componente.PC.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_CATEGORY")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="category_code")
    private int category_code;
    @Column(name="typeofcomponent")
    private String typeOfComponent;
    @Column(name="quantity")
    private int quantity;
    @OneToMany(targetEntity = ComponentPc.class, mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<ComponentPc> componentPcList;
}
