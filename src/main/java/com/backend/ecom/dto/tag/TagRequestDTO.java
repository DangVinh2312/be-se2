package com.backend.ecom.dto.tag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class TagRequestDTO {
    @Size(min = 2)
    private String name;
}
