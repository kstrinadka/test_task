package com.kstrinadka.shift_lab_task.repository.articles;


import com.kstrinadka.shift_lab_task.entity.articles.LaptopEntity;
import com.kstrinadka.shift_lab_task.entity.articles.ScreenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ScreenRepository extends CrudRepository<ScreenEntity, Long> {

    Optional<ScreenEntity> findById(Long id);

    List<ScreenEntity> findAll();

    ScreenEntity save(ScreenEntity screenEntity);

}
