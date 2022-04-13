package com.backend.ecom.services;

import com.backend.ecom.dto.product.ProductDetailDTO;
import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Category;
import com.backend.ecom.entities.Product;
import com.backend.ecom.entities.Tag;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.dto.product.ProductRequestDTO;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.BrandRepository;
import com.backend.ecom.repositories.CategoryRepository;
import com.backend.ecom.repositories.ProductRepository;
import com.backend.ecom.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BrandRepository brandRepository;

    public List<ProductShortInfoDTO> getAllProducts(Boolean deleted) {
        List<ProductShortInfoDTO> productShortInfo = new ArrayList<>();
        List<Product> products = productRepository.findAllByDeleted(deleted);

        products.forEach(product -> productShortInfo.add(new ProductShortInfoDTO(product)));

        return productShortInfo;
    }

    public ResponseEntity<ResponseObject> getProductDetail(@PathVariable("id") Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + id));
        ProductDetailDTO productDetail = new ProductDetailDTO(product);
        return ResponseEntity.ok(new ResponseObject("ok", "Query product successfully", productDetail));
    }

    public ResponseEntity<ResponseObject> getAllCategoriesByProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Not found product with id: " + productId);
        }
        List<Category> categories = categoryRepository.findCategoriesByProductsId(productId);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query categories successfully", categories));

    }

    public ResponseEntity<ResponseObject> getAllTagsByProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Not found product with id: " + productId);
        }

        List<Tag> tags = tagRepository.findTagsByProductsId(productId);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query categories successfully", tags));

    }


    public ResponseEntity<ResponseObject> createProduct(ProductRequestDTO productRequestDTO) {
        boolean exist = productRepository.existsByName(productRequestDTO.getName());
        if (exist) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseObject("error", "Product is already existed", ""));
        }
        Product product = new Product(productRequestDTO);
        product.setCreatedAt(Timestamp.from(Instant.now()));
        product.setUpdatedAt(Timestamp.from(Instant.now()));
        for (Integer categoryId : productRequestDTO.getCategoryIds()) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found category with id: " + categoryId));
            product.addCategory(category);
        }
//        Tag tag = tagRepository.findById(productRequestDTO.getTagId())
//                .orElseThrow(() -> new ResourceNotFoundException("Not found tag with id: " + productRequestDTO.getTagId()));
//        product.addTag(tag);
        Brand brand = brandRepository.findById(productRequestDTO.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id: " + productRequestDTO.getBrandId()));
        product.setBrand(brand);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Create product successfully", productRepository.save(product)));
    }


    public ResponseEntity<ResponseObject> updateProduct(Long id, ProductRequestDTO productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id = " + id));
        if(productRepository.existsByName(productRequest.getName())){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("error", "Product name is already existed", productRequest.getName()));
        }
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setDetail(productRequest.getDetail());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        product.setCategories(new HashSet<>());
        for (Integer categoryId : productRequest.getCategoryIds()) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found the category with id: " + categoryId));
            product.addCategory(category);
        }
        Brand brand = brandRepository.findById(productRequest.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found the category with id: " + productRequest.getBrandId()));
        product.setBrand(brand);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Update product successfully", productRepository.save(product)));
    }

    @Transactional
    public ResponseEntity<ResponseObject> softDeleteOneOrManyProducts(List<Long> ids) {
        try {
            productRepository.softDeleteAllByIds(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Delete products successfully", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product with id: " + e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseObject> forceDeleteOneOrManyProducts(List<Long> ids) {
        try {
            productRepository.deleteAllById(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Delete products permanently", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product with id: " + e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseObject> restoreOneOrManyProducts(List<Long> ids) {
        try {
            productRepository.restoreAllByIds(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Restore products successfully", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product with id: " + e);
        }
    }

    public ResponseEntity<ResponseObject> addTagOrCategoryOrBrandToProduct(Long productId, Integer categoryId, Integer tagId, Integer brandId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
        if (categoryId.intValue() != 0) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found category with id: " + categoryId));
            product.addCategory(category);
        }
        if (tagId.intValue() != 0) {
            Tag tag = tagRepository.findById(tagId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found tag with id: " + tagId));
            product.addTag(tag);
        }
        if (brandId.intValue() != 0) {
            Brand brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id: " + brandId));
            product.setBrand(brand);
        }
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Update product successfully", product));
    }

    public ResponseEntity<ResponseObject> deleteCategoryOrTagOrBrandFromProduct(Long productId, Integer categoryId, Integer tagId, Boolean brandBool) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
        if (categoryId.intValue() != 0) {
            product.removeCategory(categoryId);
        }
        if (tagId.intValue() != 0) {
            product.removeTag(tagId);
        }
        if (brandBool.booleanValue() != false) {
            product.removeBrand();
        }
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete successfully", product));

    }

}
