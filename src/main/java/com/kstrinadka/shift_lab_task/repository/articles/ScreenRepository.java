package com.kstrinadka.shift_lab_task.repository.articles;


import com.kstrinadka.shift_lab_task.entity.articles.ScreenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ScreenRepository extends CrudRepository<ScreenEntity, Long> {
}
