package com.kstrinadka.shift_lab_task.controllers;


import com.kstrinadka.shift_lab_task.entity.ShopEntity;
import com.kstrinadka.shift_lab_task.service.ShopService;
import com.kstrinadka.shift_lab_task.transferLayer.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {


    @Autowired
    ShopService shopService;


    @GetMapping("")
    private List<ShopEntity> getAllArticle()
    {
        return shopService.getAllArticles();
    }


    @GetMapping("/{id}")
    private ShopEntity getArticle(@PathVariable("id") Long id)
    {
        return shopService.getArticleById(id);
    }


    @DeleteMapping("/{id}")
    private void deleteArticle(@PathVariable("id") Long id)
    {
        shopService.delete(id);
    }


    private ShopEntity shopDtoToEntity(ShopDTO shopDTO){
        ShopEntity shopEntity = new ShopEntity();

        shopEntity.setId(shopDTO.id());
        shopEntity.setAmount(shopDTO.amount());
        shopEntity.setCost(shopDTO.cost());
        shopEntity.setManufacturer(shopDTO.manufacturer());
        shopEntity.setSerial(shopDTO.serial());
        shopEntity.setType(shopDTO.type());

        return shopEntity;
    }
}
