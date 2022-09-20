package com.kstrinadka.shift_lab_task.service;

import com.kstrinadka.shift_lab_task.entity.articles.HddEntity;
import com.kstrinadka.shift_lab_task.transferLayer.articles.HddDTO;

import java.util.List;

public interface HddService {

    public List<HddEntity> getAllHdd();

    public HddEntity getHddById(Long id);

    public void saveOrUpdate(HddEntity hddEntity);

    public void delete(Long id);

    public HddDTO update(Long id, HddDTO update);
}
