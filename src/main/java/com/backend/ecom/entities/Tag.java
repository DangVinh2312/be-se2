package com.backend.ecom.entities;

import com.backend.ecom.dto.tag.TagRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tags")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public Tag(TagRequestDTO tagRequestDTO){
        this.name = tagRequestDTO.getName();
    }
}
