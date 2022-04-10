package com.backend.ecom.controllers;

import com.backend.ecom.entities.Tag;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/products/{productId}/tags")
    public ResponseEntity<ResponseObject> getAllTagsByProductId(@PathVariable(value = "productId") Long productId) {
        return tagService.getAllTagsByProductId(productId);
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<ResponseObject> getTagsById(@PathVariable(value = "id") Integer id) {
        return tagService.getTagsById(id);
    }

    @GetMapping("/tags/{tagId}/products")
    public ResponseEntity<ResponseObject> getAllProductsByTagId(@PathVariable(value = "tagId") Integer tagId) {
        return tagService.getAllProductsByTagId(tagId);
    }

    @PostMapping("/products/{productId}/tags")
    public ResponseEntity<ResponseObject> addTag(@PathVariable(value = "productId") Long productId, @RequestBody Tag tagRequest) {
        return tagService.addTag(productId, tagRequest);
    }

    @PutMapping("/tags/update/{id}")
    public ResponseEntity<ResponseObject> updateTag(@PathVariable("id") Integer id, @RequestBody Tag tagRequest) {
        return tagService.updateTag(id, tagRequest);
    }

    @DeleteMapping("/products/{productId}/tags/delete/{tagId}")
    public ResponseEntity<ResponseObject> deleteTagFromTutorial(@PathVariable(value = "productId") Long productId, @PathVariable(value = "tagId") Integer tagId) {
        return tagService.deleteTagFromTutorial(productId, tagId);
    }

    @DeleteMapping("/tags/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTag(@PathVariable("id") Integer id) {
        return tagService.deleteTag(id);
    }

}
