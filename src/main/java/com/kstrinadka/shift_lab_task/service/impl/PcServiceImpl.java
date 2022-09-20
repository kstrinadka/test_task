package com.kstrinadka.shift_lab_task.service.impl;


import com.kstrinadka.shift_lab_task.entity.articles.PcEntity;
import com.kstrinadka.shift_lab_task.repository.articles.PcRepository;
import com.kstrinadka.shift_lab_task.service.PcService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.PcDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PcServiceImpl implements PcService {


    @Autowired
    PcRepository pcRepository;



    public List<PcEntity> getAllPc()
    {
        List<PcEntity> pcEntityList = new ArrayList<>();
        pcRepository.findAll().forEach(pc -> pcEntityList.add(pc));
        return pcEntityList;
    }



    public PcEntity getPcById(Long id)
    {
        return pcRepository.findById(id).get();
    }


    public void saveOrUpdate(PcEntity pcEntity)
    {
        pcRepository.save(pcEntity);
    }



    public void delete(Long id)
    {
        pcRepository.deleteById(id);
    }


    public PcDTO update(Long id, PcDTO updateDTO) {
        PcEntity pcEntity = pcRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        pcEntity = PcMapper.map(updateDTO, pcEntity);

        pcRepository.save(pcEntity);

        return PcMapper.map(pcEntity);
    }

    private class PcMapper{

        static public PcEntity map(PcDTO newPcDTO, PcEntity oldEntity) {

            PcEntity newPcEntity = oldEntity;

            if (newPcDTO.type() != null && !newPcDTO.type().equals("")){
                newPcEntity.setType(newPcDTO.type());
            }
            if (newPcDTO.serial() != null && !newPcDTO.serial().equals("")){
                newPcEntity.setSerial(newPcDTO.serial());
            }
            if (newPcDTO.manufacturer() != null && !newPcDTO.manufacturer().equals("")){
                newPcEntity.setManufacturer(newPcDTO.manufacturer());
            }
            if (newPcDTO.cost() != null && !newPcDTO.cost().equals("")){
                newPcEntity.setCost(newPcDTO.cost());
            }
            if (newPcDTO.amount() != null && !newPcDTO.amount().equals("")){
                newPcEntity.setAmount(newPcDTO.amount());
            }
            if (newPcDTO.pcType() != null && !newPcDTO.pcType().equals("")){
                newPcEntity.setPcType(newPcDTO.pcType());
            }

            return newPcEntity;

        }

        static public PcDTO map(PcEntity pcEntity) {
            PcDTO dto = new PcDTO(pcEntity.getId(), pcEntity.getType(), pcEntity.getSerial(), pcEntity.getManufacturer(),
                    pcEntity.getCost(), pcEntity.getAmount(), pcEntity.getPcType());

            return dto;
        }

    }
}
