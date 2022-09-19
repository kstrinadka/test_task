package com.kstrinadka.shift_lab_task.repository;

import com.kstrinadka.shift_lab_task.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, Long> {



}
