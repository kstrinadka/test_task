package com.kstrinadka.shift_lab_task.service;


import com.kstrinadka.shift_lab_task.entity.ShopEntity;
import com.kstrinadka.shift_lab_task.transferLayer.ShopDTO;

import java.util.List;

public interface ShopService {

    public List<ShopEntity> getAllArticles();

    public ShopEntity getArticleById(Long id);

    public void saveOrUpdate(ShopEntity shopEntity);

    public void delete(Long id);

    public ShopDTO update(Long id, ShopDTO update);
}
