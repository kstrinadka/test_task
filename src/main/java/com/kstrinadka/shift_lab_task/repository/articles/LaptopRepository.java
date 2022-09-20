package com.kstrinadka.shift_lab_task.repository.articles;


import com.kstrinadka.shift_lab_task.entity.articles.LaptopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LaptopRepository extends CrudRepository<LaptopEntity, Long> {

    Optional<LaptopEntity> findById(Long id);

    List<LaptopEntity> findAll();

    LaptopEntity save(LaptopEntity laptopEntity);

}
