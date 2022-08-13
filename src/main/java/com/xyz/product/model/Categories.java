package com.xyz.product.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @Column(name = "categoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
    @OneToMany(targetEntity = SubCategories.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_subcategory",
            joinColumns = @JoinColumn(name = "categoryId"),
            inverseJoinColumns = @JoinColumn(name = "subCategoryId")
    )
    @ToString.Exclude
    private List<SubCategories> subCategories;

}
