package com.backend.ecom.repositories;

import com.backend.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByName(String name);
    List<Product> findAllByDeleted(Boolean deleted);

    List<Product> findProductsByTagsId(Integer tagId);

    List<Product> findProductsByCategoriesId(Integer categoryId);

    @Modifying
    @Query("UPDATE User SET deleted = true, deletedAt = current_date WHERE id in ?1")
    void softDeleteAllByIds (Iterable<? extends Long> ids);

    @Modifying
    @Query("UPDATE User SET deleted = false WHERE id in ?1")
    void restoreAllByIds(Iterable<? extends Long>  ids);
}
