package com.kstrinadka.shift_lab_task.repository;

import com.kstrinadka.shift_lab_task.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {

    Optional<ShopEntity> findById(Long id);

    List<ShopEntity> findAll();

    ShopEntity save(ShopEntity shopEntity);

}
