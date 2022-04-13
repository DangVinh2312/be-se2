package com.backend.ecom.entities;

import com.backend.ecom.dto.product.ProductRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String detail;

    private Integer quantity;

    private Double price;

    @Transient
    private Double totalPrice;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> image = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Discount discount;

    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "product_tags",
            joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tagId", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems = new HashSet<>();

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private boolean deleted = Boolean.FALSE;

    private Timestamp deletedAt;

    public Product(ProductRequestDTO productRequestDTO) {
        this.name = productRequestDTO.getName();
        this.description = productRequestDTO.getDescription();
        this.detail = productRequestDTO.getDetail();
        this.quantity = productRequestDTO.getQuantity();
        this.price = productRequestDTO.getPrice();
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getProducts().add(this);
    }

    public void removeTag(Integer tagId) {
        Tag tag = this.tags.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
        if (tag != null) this.tags.remove(tag);
        tag.getProducts().remove(this);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getProducts().add(this);
    }

    public void removeCategory(Integer categoryId) {
        Category category = this.categories.stream().filter(t -> t.getId() == categoryId).findFirst().orElse(null);
        if (category != null) this.categories.remove(category);
        category.getProducts().remove(this);
    }

    public void removeBrand() {
        this.brand.getProducts().remove(this);
        this.brand = null;
    }
}
