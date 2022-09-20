package com.kstrinadka.shift_lab_task.repository.articles;


import com.kstrinadka.shift_lab_task.entity.articles.HddEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface HddRepository  extends CrudRepository<HddEntity, Long> {

    Optional<HddEntity> findById(Long id);

    List<HddEntity> findAll();

    HddEntity save(HddEntity hddEntity);

}
