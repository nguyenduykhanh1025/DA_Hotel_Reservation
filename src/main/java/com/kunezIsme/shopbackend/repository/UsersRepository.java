package com.kunezIsme.shopbackend.repository;

import com.kunezIsme.shopbackend.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByUserName(String username);
}
