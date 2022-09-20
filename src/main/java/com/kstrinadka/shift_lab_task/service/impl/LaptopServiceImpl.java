package com.kstrinadka.shift_lab_task.service.impl;



import com.kstrinadka.shift_lab_task.entity.articles.LaptopEntity;
import com.kstrinadka.shift_lab_task.repository.articles.LaptopRepository;
import com.kstrinadka.shift_lab_task.service.LaptopService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.LaptopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {


    @Autowired
    LaptopRepository laptopRepository;



    public List<LaptopEntity> getAllLaptop()
    {
        List<LaptopEntity> laptopEntityList = new ArrayList<>();
        laptopRepository.findAll().forEach(laptop -> laptopEntityList.add(laptop));
        return laptopEntityList;
    }



    public LaptopEntity getLaptopById(Long id)
    {
        return laptopRepository.findById(id).get();
    }


    public void saveOrUpdate(LaptopEntity laptopEntity)
    {
        laptopRepository.save(laptopEntity);
    }



    public void delete(Long id)
    {
        laptopRepository.deleteById(id);
    }


    public LaptopDTO update(Long id, LaptopDTO updateDTO) {
        LaptopEntity laptopEntity = laptopRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        laptopEntity = LaptopServiceImpl.LaptopMapper.map(updateDTO, laptopEntity);

        laptopRepository.save(laptopEntity);

        return LaptopServiceImpl.LaptopMapper.map(laptopEntity);
    }

    private class LaptopMapper{

        static public LaptopEntity map(LaptopDTO newDTO, LaptopEntity oldEntity) {

            LaptopEntity newLaptopEntity = oldEntity;

            if (newDTO.type() != null && !newDTO.type().equals("")){
                newLaptopEntity.setType(newDTO.type());
            }
            if (newDTO.serial() != null && !newDTO.serial().equals("")){
                newLaptopEntity.setSerial(newDTO.serial());
            }
            if (newDTO.manufacturer() != null && !newDTO.manufacturer().equals("")){
                newLaptopEntity.setManufacturer(newDTO.manufacturer());
            }
            if (newDTO.cost() != null && !newDTO.cost().equals("")){
                newLaptopEntity.setCost(newDTO.cost());
            }
            if (newDTO.amount() != null && !newDTO.amount().equals("")){
                newLaptopEntity.setAmount(newDTO.amount());
            }
            if (newDTO.diagonal() != null && !newDTO.diagonal().equals("")){
                newLaptopEntity.setDiagonal(newDTO.diagonal());
            }

            return newLaptopEntity;

        }

        static public LaptopDTO map(LaptopEntity laptopEntity) {
            LaptopDTO dto = new LaptopDTO(laptopEntity.getId(), laptopEntity.getType(), laptopEntity.getSerial(), laptopEntity.getManufacturer(),
                    laptopEntity.getCost(), laptopEntity.getAmount(), laptopEntity.getDiagonal());

            return dto;
        }

    }
}
