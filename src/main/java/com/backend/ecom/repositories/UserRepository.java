package com.backend.ecom.repositories;

import com.backend.ecom.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String authenticatedUsername);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Query("select u.cart from User u where u.cart is null and u.username = ?1")
    User findCartByUsername (String name);

    User getByUsername (String authenticatedUsername);

    List<User> findAllByDeleted (Boolean deleted);

    @Query("select u from User u where u.role.id = ?2 and u.deleted = ?1")
    List<User> findAllByDeletedAndRoleId (Boolean deleted, Long roleId);

    @Modifying
    @Query("UPDATE User SET deleted = true, deletedAt = current_date WHERE id in ?1")
    void softDeleteAllByIds (Iterable<? extends Long> ids);

    @Modifying
    @Query("UPDATE User SET deleted = false WHERE id in ?1")
    void restoreAllByIds(Iterable<? extends Long>  ids);
}
