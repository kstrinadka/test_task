package com.kstrinadka.shift_lab_task.service;

import com.kstrinadka.shift_lab_task.entity.articles.ScreenEntity;
import com.kstrinadka.shift_lab_task.transferLayer.articles.ScreenDTO;

import java.util.List;

public interface ScreenService {

    public List<ScreenEntity> getAllScreen();

    public ScreenEntity getScreenById(Long id);

    public void saveOrUpdate(ScreenEntity screenEntity);

    public void delete(Long id);

    public ScreenDTO update(Long id, ScreenDTO update);
}
