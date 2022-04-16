package com.backend.ecom.repositories;

import com.backend.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByName(String name);

    List<Product> findAllByDeleted(Boolean deleted);

    List<Product> findProductsByTags_id(Integer tagId);

    List<Product> findProductsByCategories_id(Integer categoryId);

    List<Product> findProductsByBrandId(Integer brandId);

    List<Product> findProductsByDiscountId(Long discountId);

    @Modifying
    @Query("UPDATE Product SET deleted = true, deletedAt = current_date WHERE id in ?1")
    void softDeleteAllByIds (Iterable<? extends Long> ids);

    @Modifying
    @Query("UPDATE Product SET deleted = false WHERE id in ?1")
    void restoreAllByIds(Iterable<? extends Long>  ids);

    void deleteAllByBrandId(Integer brandId);}
