package com.backend.ecom.services;

import com.backend.ecom.dto.product.ProductDetailDTO;
import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.entities.Product;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.request.ProductRequest;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductShortInfoDTO> getAllProducts(Boolean deleted) {
        List<ProductShortInfoDTO> productShortInfo = new ArrayList<>();
        List<Product> products = productRepository.findAllByDeleted(deleted);

        products.forEach(product -> productShortInfo.add(new ProductShortInfoDTO(product)));

        return productShortInfo;
    }

    public ResponseEntity<ResponseObject> getProductDetail(@PathVariable("id") Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + id));
        ProductDetailDTO userDetail = new ProductDetailDTO(product);
        return ResponseEntity.ok(new ResponseObject("ok", "Query product successfully", userDetail));
    }

    public ResponseEntity<ResponseObject> createProduct(ProductRequest productRequest) {
        boolean exist = productRepository.existsByName(productRequest.getName());
        if (exist) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseObject("error", "Product is already existed", ""));
        }
        Product product = new Product(productRequest);
        product.setCreatedAt(Timestamp.from(Instant.now()));
        product.setUpdatedAt(Timestamp.from(Instant.now()));
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok", "Create product successfully", product));

    }

    public ResponseEntity<ResponseObject> updateProduct(Long id, Product product) {
        Product _product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id = " + id));
        _product.setName(product.getName());
        _product.setDescription(product.getDescription());
        _product.setDetail(product.getDetail());
        _product.setQuantity(product.getQuantity());
        _product.setPrice(product.getPrice());
        _product.setImage(product.getImage());
        _product.setBrand(product.getBrand());
        _product.setCategories(product.getCategories());
        _product.setTags(product.getTags());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Update product successfully", _product));
    }

    @Transactional
    public ResponseEntity<ResponseObject> softDeleteOneOrManyUsers(List<Long> ids) {
        try {
            productRepository.softDeleteAllByIds(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Delete products successfully", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product with id: " + e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseObject> forceDeleteOneOrManyUsers(List<Long> ids) {
        try {
            productRepository.deleteAllById(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Delete products permanently", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product with id: " + e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseObject> restoreOneOrManyUsers(List<Long> ids) {
        try {
            productRepository.restoreAllByIds(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Restore products successfully", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product with id: " + e);
        }
    }

}
