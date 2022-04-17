package com.backend.ecom.services;

import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.dto.tag.TagRequestDTO;
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

    public ResponseEntity<ResponseObject> getTagDetail(Integer id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found tag with id: " + id));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query tag successfully", tag));
    }

    public ResponseEntity<ResponseObject> getAllProductsByTagId(Integer tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new ResourceNotFoundException("Not found tag with id:" + tagId);
        }
        List<ProductShortInfoDTO> productsShortInfo = new ArrayList<>();
        List<Product> products = productRepository.findProductsByTags_idAndDeleted(tagId, false);

        products.forEach(product -> productsShortInfo.add(new ProductShortInfoDTO(product)));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query products successfully", productsShortInfo));
    }

    public ResponseEntity<ResponseObject> createTag(TagRequestDTO tagRequest) {
        boolean exist = tagRepository.existsByName(tagRequest.getName());
        if (exist) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseObject("error", "Tag is already existed", ""));
        }
        Tag tag = new Tag(tagRequest);
        tagRepository.save(tag);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Create tag successfully", tag));
    }

    public ResponseEntity<ResponseObject> updateTag(Integer id, TagRequestDTO tagRequest) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found tag with id:" + id));
        boolean existName = tagRepository.existsByName(tagRequest.getName());
        if (existName){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseObject("error", "Tag name is already existed", ""));
        }
        tag.setName(tagRequest.getName());
        tagRepository.save(tag);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Update tag successfully", tag));
    }

    public ResponseEntity<ResponseObject> deleteTag(Integer id) {
        if (!tagRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found tag with id:" + id);
        }
        tagRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete tag successfully", ""));
    }

}
