package com.kunezIsme.shopbackend.repository;

import com.kunezIsme.shopbackend.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
    RolesEntity findByName(String name);
}
