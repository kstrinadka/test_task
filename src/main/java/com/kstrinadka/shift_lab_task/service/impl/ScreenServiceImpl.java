package com.kstrinadka.shift_lab_task.service.impl;



import com.kstrinadka.shift_lab_task.entity.articles.ScreenEntity;

import com.kstrinadka.shift_lab_task.repository.articles.ScreenRepository;
import com.kstrinadka.shift_lab_task.service.ScreenService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.ScreenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    ScreenRepository screenRepository;



    public List<ScreenEntity> getAllScreen()
    {
        List<ScreenEntity> screenEntityList = new ArrayList<>();
        screenRepository.findAll().forEach(screen -> screenEntityList.add(screen));
        return screenEntityList;
    }



    public ScreenEntity getScreenById(Long id)
    {
        return screenRepository.findById(id).get();
    }


    public void saveOrUpdate(ScreenEntity screenEntity)
    {
        screenRepository.save(screenEntity);
    }



    public void delete(Long id)
    {
        screenRepository.deleteById(id);
    }



    public ScreenDTO update(Long id, ScreenDTO updateDTO) {
        ScreenEntity screenEntity = screenRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        screenEntity = ScreenMapper.map(updateDTO, screenEntity);

        screenRepository.save(screenEntity);

        return ScreenMapper.map(screenEntity);
    }

    private class ScreenMapper{

        static public ScreenEntity map(ScreenDTO newScreenDTO, ScreenEntity oldEntity) {

            ScreenEntity newScreenEntity = oldEntity;

            if (newScreenDTO.type() != null && !newScreenDTO.type().equals("")){
                newScreenEntity.setType(newScreenDTO.type());
            }
            if (newScreenDTO.serial() != null && !newScreenDTO.serial().equals("")){
                newScreenEntity.setSerial(newScreenDTO.serial());
            }
            if (newScreenDTO.manufacturer() != null && !newScreenDTO.manufacturer().equals("")){
                newScreenEntity.setManufacturer(newScreenDTO.manufacturer());
            }
            if (newScreenDTO.cost() != null && !newScreenDTO.cost().equals("")){
                newScreenEntity.setCost(newScreenDTO.cost());
            }
            if (newScreenDTO.amount() != null && !newScreenDTO.amount().equals("")){
                newScreenEntity.setAmount(newScreenDTO.amount());
            }
            if (newScreenDTO.diagonal() != null && !newScreenDTO.diagonal().equals("")){
                newScreenEntity.setDiagonal(newScreenDTO.diagonal());
            }

            return newScreenEntity;

        }

        static public ScreenDTO map(ScreenEntity screenEntity) {
            ScreenDTO dto = new ScreenDTO(screenEntity.getId(), screenEntity.getType(), screenEntity.getSerial(), screenEntity.getManufacturer(),
                    screenEntity.getCost(), screenEntity.getAmount(), screenEntity.getDiagonal());

            return dto;
        }

    }
}
