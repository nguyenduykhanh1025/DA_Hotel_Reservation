package com.kunezIsme.shopbackend.rest.type;

import com.kunezIsme.shopbackend.rest.type.model.Type;
import com.kunezIsme.shopbackend.service.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;
    private final TypeMapper typeMapper;

    @GetMapping("/{id}")
    public Type getTypeFollowId(@PathVariable("id") int id) {
        log.info(typeMapper.toType(typeService.getTypeFollowId(1)).getName());
        return typeMapper.toType(typeService.getTypeFollowId(id));
    }

    @PostMapping
    public Type addType(@RequestBody @Validated Type type) {
        return typeMapper.toType(typeService.addType(typeMapper.toTypeEntity(type)));
    }
}
