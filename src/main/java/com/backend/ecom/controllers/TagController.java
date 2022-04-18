package com.backend.ecom.controllers;

import com.backend.ecom.dto.tag.TagRequestDTO;
import com.backend.ecom.entities.Tag;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/all")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getTagDetail(@PathVariable(value = "id") Integer id) {
        return tagService.getTagDetail(id);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<ResponseObject> getAllProductsByTagId(@PathVariable(value = "tagId") Integer id) {
        return tagService.getAllProductsByTagId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createTag (@RequestBody TagRequestDTO tagRequest){
        return tagService.createTag(tagRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateTag(@PathVariable("id") Integer id, @RequestBody TagRequestDTO tagRequest) {
        return tagService.updateTag(id, tagRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTag(@PathVariable("id") Integer id) {
        return tagService.deleteTag(id);
    }

}
