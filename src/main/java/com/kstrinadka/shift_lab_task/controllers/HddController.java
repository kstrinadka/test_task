package com.kstrinadka.shift_lab_task.controllers;



import com.kstrinadka.shift_lab_task.entity.articles.HddEntity;
import com.kstrinadka.shift_lab_task.service.HddService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.HddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/hdd")
public class HddController {

    // возможно все методы должны возвращать http response
    // возможно методы тут должны быть публичными

    @Autowired
    HddService hddService;


    @GetMapping("")
    private List<HddEntity> getAllHdd()
    {
        return hddService.getAllHdd();
    }


    @GetMapping("/{id}")
    private HddEntity getHdd(@PathVariable("id") Long id) {
        return hddService.getHddById(id);
    }


    @DeleteMapping("/delete")
    private void deleteHdd(@PathVariable(name = "id") Long id) {
        hddService.delete(id);
    }


    @PostMapping("/addlist")
    @ResponseBody
    public String addHddList (@RequestBody List<HddDTO> hddDTOList) {

        for(HddDTO hddDTO: hddDTOList){
            hddService.saveOrUpdate(hddDtoToEntity(hddDTO));
        }

        return "hdd added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addHdd (@RequestBody HddDTO hddDTO) {

        hddService.saveOrUpdate(hddDtoToEntity(hddDTO));

        return "hdd added to database";
    }


    @PutMapping ( "/update/{id}")
    @ResponseBody
    public HddDTO update(@PathVariable(name = "id") Long id, @RequestBody HddDTO update) {
        return hddService.update(id, update);
    }


    private HddEntity hddDtoToEntity(HddDTO hddDTO){
        HddEntity hddEntity = new HddEntity();

        hddEntity.setId(hddDTO.id());
        hddEntity.setCapacity(hddDTO.capacity());
        hddEntity.setAmount(hddDTO.amount());
        hddEntity.setCost(hddDTO.cost());
        hddEntity.setManufacturer(hddDTO.manufacturer());
        hddEntity.setSerial(hddDTO.serial());
        hddEntity.setType(hddDTO.type());

        return hddEntity;
    }

    /*@PostMapping("")
    private Long saveHdd(@RequestBody HddEntity hddEntity) {
        hddService.saveOrUpdate(hddEntity);
        return hddEntity.getId();
    }*/
}
