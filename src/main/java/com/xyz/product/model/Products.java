package com.xyz.product.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Products {
    @Id
    @Column(name = "productId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String brand;
    private double price;
    private boolean status;

    @OneToMany(targetEntity = Tags.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    @ToString.Exclude
    private List<Tags> tags;
    @OneToMany(targetEntity = Categories.class, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Categories> categories;
}
