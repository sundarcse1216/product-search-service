package com.xyz.product.repository;

import com.xyz.product.dto.Search;
import com.xyz.product.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT DISTINCT new com.xyz.product.dto.Search(p.id, p.name, p.brand, p.price) FROM Products p" +
            " LEFT JOIN p.categories c" +
            " LEFT JOIN p.tags t" +
            " LEFT JOIN c.subCategories sc" +
            " WHERE LOWER(CONCAT(COALESCE(p.name,''), '', COALESCE(p.brand,''), '',COALESCE(c.name,''), '',COALESCE(t.name,''), '',COALESCE(t.description,''),COALESCE(sc.name,''))) LIKE LOWER(concat('%', :keyword, '%'))")
    public List<Search> productSearch(@Param("keyword") String keyword);

}
