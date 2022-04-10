package com.backend.ecom.services;

import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.entities.Product;
import com.backend.ecom.entities.Tag;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.ProductRepository;
import com.backend.ecom.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getAllTagsByProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Not found product with id: " + productId);
        }
        List<Tag> tags = tagRepository.findTagsByProductsId(productId);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query tags successfully", tags));
    }

    public ResponseEntity<ResponseObject> getTagsById(Integer id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found tag with id: " + id));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query tag successfully", tag));
    }

    public ResponseEntity<ResponseObject> getAllProductsByTagId(Integer tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new ResourceNotFoundException("Not found tag with id:" + tagId);
        }
        List<ProductShortInfoDTO> productsShortInfo = new ArrayList<>();
        List<Product> products = productRepository.findProductsByTagsId(tagId);

        products.forEach(product -> productsShortInfo.add(new ProductShortInfoDTO(product)));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query tag successfully", productsShortInfo));
    }

    public ResponseEntity<ResponseObject> addTag(Long productId, Tag tagRequest) {
        Tag tag = productRepository.findById(productId).map(product -> {
            int tagId = tagRequest.getId();
            // tag is existed
            if (tagId != 0) {
                Tag existTag = tagRepository.findById(tagId)
                        .orElseThrow(() -> new ResourceNotFoundException("Not found tag with code: " + tagId));
                product.addTag(existTag);
                productRepository.save(product);
                return existTag;
            }
                product.addTag(tagRequest);
                return tagRepository.save(tagRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Add tag successfully", tag));
    }

    public ResponseEntity<ResponseObject> updateTag(Integer id, Tag tagRequest) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found tag with id:" + id));
        tag.setName(tagRequest.getName());
        tagRepository.save(tag);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Update tag successfully", tag));
    }

    public ResponseEntity<ResponseObject> deleteTagFromTutorial(Long productId, Integer tagId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
        product.removeTag(tagId);
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete tag from product successfully", ""));
    }

    public ResponseEntity<ResponseObject> deleteTag(Integer id) {
        if (!tagRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found tag with id:" + id);
        }
        tagRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete tag successfully", ""));
    }
}
