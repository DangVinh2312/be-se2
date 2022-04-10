package com.backend.ecom.repositories;

import com.backend.ecom.entities.Category;
import com.backend.ecom.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findTagsByProductsId(Long id);
}
