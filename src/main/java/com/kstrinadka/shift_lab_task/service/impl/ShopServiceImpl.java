package com.kstrinadka.shift_lab_task.service.impl;

import com.kstrinadka.shift_lab_task.entity.ShopEntity;
import com.kstrinadka.shift_lab_task.repository.ShopRepository;
import com.kstrinadka.shift_lab_task.service.ShopService;
import com.kstrinadka.shift_lab_task.transferLayer.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;


    public List<ShopEntity> getAllArticles()
    {
        List<ShopEntity> shopEntityList = new ArrayList<>();
        shopRepository.findAll().forEach(article -> shopEntityList.add(article));
        return shopEntityList;
    }



    public ShopEntity getArticleById(Long id)
    {
        return shopRepository.findById(id).get();
    }


    public void saveOrUpdate(ShopEntity shopEntity)
    {
        shopRepository.save(shopEntity);
    }



    public void delete(Long id)
    {
        shopRepository.deleteById(id);
    }



    public ShopDTO update(Long id, ShopDTO updateDTO) {
        ShopEntity shopEntity = shopRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        shopEntity = ShopMapper.map(updateDTO, shopEntity);

        shopRepository.save(shopEntity);

        return ShopMapper.map(shopEntity);
    }

    private class ShopMapper{

        static public ShopEntity map(ShopDTO newShopDTO, ShopEntity oldEntity) {

            ShopEntity newShopEntity = oldEntity;

            if (newShopDTO.type() != null && !newShopDTO.type().equals("")){
                newShopEntity.setType(newShopDTO.type());
            }
            if (newShopDTO.serial() != null && !newShopDTO.serial().equals("")){
                newShopEntity.setSerial(newShopDTO.serial());
            }
            if (newShopDTO.manufacturer() != null && !newShopDTO.manufacturer().equals("")){
                newShopEntity.setManufacturer(newShopDTO.manufacturer());
            }
            if (newShopDTO.cost() != null && !newShopDTO.cost().equals("")){
                newShopEntity.setCost(newShopDTO.cost());
            }
            if (newShopDTO.amount() != null && !newShopDTO.amount().equals("")){
                newShopEntity.setAmount(newShopDTO.amount());
            }


            return newShopEntity;

        }

        static public ShopDTO map(ShopEntity shopEntity) {
            ShopDTO dto = new ShopDTO(shopEntity.getId(), shopEntity.getType(), shopEntity.getSerial(), shopEntity.getManufacturer(),
                    shopEntity.getCost(), shopEntity.getAmount());

            return dto;
        }

    }
}
