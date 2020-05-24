package com.kunezIsme.shopbackend.rest.type.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(int id) {
        super("Type id not found : " + id);
    }
}
