package com.kunezIsme.shopbackend.service;

import com.kunezIsme.shopbackend.entity.TypeEntity;
import com.kunezIsme.shopbackend.repository.TypesRepository;
import com.kunezIsme.shopbackend.rest.type.exception.TypeNotFoundException;
import com.kunezIsme.shopbackend.rest.type.model.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeService {

    private final TypesRepository typesRepository;

    public TypeEntity getTypeFollowId(int id) {
        final TypeEntity typeEntity = this.typesRepository.findById(id).orElseThrow(() ->
                new TypeNotFoundException(id));
        return typeEntity;
    }

    public TypeEntity addType(TypeEntity typeEntity) {
        return this.typesRepository.save(typeEntity);
    }
}
