package com.xyz.product.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubCategories {
    @Id
    @Column(name = "subCategoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subCategoryId;
    private String name;

}
