package com.kstrinadka.shift_lab_task.repository.articles;


import com.kstrinadka.shift_lab_task.entity.articles.LaptopEntity;
import com.kstrinadka.shift_lab_task.entity.articles.PcEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PcRepository extends CrudRepository<PcEntity, Long> {

    Optional<PcEntity> findById(Long id);

    List<PcEntity> findAll();

    PcEntity save(PcEntity pcEntity);

}
