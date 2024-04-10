package com.barcode.aviation.tool.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.aviation.tool.inventory.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
