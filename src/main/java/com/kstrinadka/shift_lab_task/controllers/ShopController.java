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


    @PostMapping("/addlist")
    @ResponseBody
    public String addShopList (@RequestBody List<ShopDTO> shopDTOList) {

        for(ShopDTO shopDTO: shopDTOList){
            shopService.saveOrUpdate(shopDtoToEntity(shopDTO));
        }

        return "article added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addShop (@RequestBody ShopDTO shopDTO) {

        shopService.saveOrUpdate(shopDtoToEntity(shopDTO));

        return "hdd added to database";
    }


    @PutMapping ( "/update/{id}")
    @ResponseBody
    public ShopDTO update(@PathVariable(name = "id") Long id, @RequestBody ShopDTO update) {
        return shopService.update(id, update);
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
