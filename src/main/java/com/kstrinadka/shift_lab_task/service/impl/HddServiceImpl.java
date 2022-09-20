package com.kstrinadka.shift_lab_task.service.impl;

import com.kstrinadka.shift_lab_task.entity.articles.HddEntity;
import com.kstrinadka.shift_lab_task.repository.articles.HddRepository;
import com.kstrinadka.shift_lab_task.service.HddService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.HddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HddServiceImpl implements HddService {

    @Autowired
    HddRepository hddRepository;



    public HddDTO update(Long id, HddDTO updateDTO) {
        HddEntity hddEntity = hddRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        hddEntity = HddMapper.map(updateDTO, hddEntity);

        hddRepository.save(hddEntity);

        return HddMapper.map(hddEntity);
    }


    public List<HddEntity> getAllHdd() {
        List<HddEntity> hddEntityList = new ArrayList<>();
        hddRepository.findAll().forEach(hdd -> hddEntityList.add(hdd));
        return hddEntityList;
    }



    public HddEntity getHddById(Long id) {
        return hddRepository.findById(id).get();
    }


    public void saveOrUpdate(HddEntity hddEntity) {
        hddRepository.save(hddEntity);
    }



    public void delete(Long id) {
        hddRepository.deleteById(id);
    }



    private class HddMapper{

        static public HddEntity map(HddDTO newHddDTO, HddEntity oldEntity) {

            HddEntity newHddEntity = oldEntity;

            if (newHddDTO.type() != null && !newHddDTO.type().equals("")){
                newHddEntity.setType(newHddDTO.type());
            }
            if (newHddDTO.serial() != null && !newHddDTO.serial().equals("")){
                newHddEntity.setSerial(newHddDTO.serial());
            }
            if (newHddDTO.manufacturer() != null && !newHddDTO.manufacturer().equals("")){
                newHddEntity.setManufacturer(newHddDTO.manufacturer());
            }
            if (newHddDTO.cost() != null && !newHddDTO.cost().equals("")){
                newHddEntity.setCost(newHddDTO.cost());
            }
            if (newHddDTO.amount() != null && !newHddDTO.amount().equals("")){
                newHddEntity.setAmount(newHddDTO.amount());
            }
            if (newHddDTO.capacity() != null && !newHddDTO.capacity().equals("")){
                newHddEntity.setCapacity(newHddDTO.capacity());
            }

            return newHddEntity;

        }

        static public HddDTO map(HddEntity hddEntity) {
            HddDTO dto = new HddDTO(hddEntity.getId(), hddEntity.getType(), hddEntity.getSerial(), hddEntity.getManufacturer(),
                    hddEntity.getCost(), hddEntity.getAmount(), hddEntity.getCapacity());

            return dto;
        }

    }
}
