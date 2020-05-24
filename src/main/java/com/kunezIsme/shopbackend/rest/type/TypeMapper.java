package com.kunezIsme.shopbackend.rest.type;

import com.kunezIsme.shopbackend.entity.TypeEntity;
import com.kunezIsme.shopbackend.rest.type.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public abstract class TypeMapper {

    public abstract TypeEntity toTypeEntity(Type type);

    public abstract Type toType(TypeEntity typeEntity);
}
