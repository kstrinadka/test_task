package com.kstrinadka.shift_lab_task.service;

import com.kstrinadka.shift_lab_task.entity.articles.LaptopEntity;
import com.kstrinadka.shift_lab_task.transferLayer.articles.LaptopDTO;


import java.util.List;

public interface LaptopService {

    public List<LaptopEntity> getAllLaptop();

    public LaptopEntity getLaptopById(Long id);

    public void saveOrUpdate(LaptopEntity laptopEntity);

    public void delete(Long id);

    public LaptopDTO update(Long id, LaptopDTO update);
}
