package com.kunezIsme.shopbackend.rest.type.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    int id;

    @NotEmpty
    @NotBlank
    String name;
}
