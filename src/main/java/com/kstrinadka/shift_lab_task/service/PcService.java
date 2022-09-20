package com.kstrinadka.shift_lab_task.service;

import com.kstrinadka.shift_lab_task.entity.articles.PcEntity;
import com.kstrinadka.shift_lab_task.transferLayer.articles.PcDTO;

import java.util.List;

public interface PcService {

    public List<PcEntity> getAllPc();

    public PcEntity getPcById(Long id);

    public void saveOrUpdate(PcEntity pcEntity);

    public void delete(Long id);

    public PcDTO update(Long id, PcDTO update);
}
