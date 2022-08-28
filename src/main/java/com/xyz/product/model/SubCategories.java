package com.xyz.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategories {
    @Id
    @Column(name = "subCategoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subCategoryId;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Categories category;

}
