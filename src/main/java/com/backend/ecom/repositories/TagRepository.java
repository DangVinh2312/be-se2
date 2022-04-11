package com.backend.ecom.repositories;

import com.backend.ecom.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Boolean existsByName(String name);

    List<Tag> findTagsByProductsId(Long id);
}
