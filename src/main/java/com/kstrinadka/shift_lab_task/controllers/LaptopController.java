package com.kstrinadka.shift_lab_task.controllers;



import com.kstrinadka.shift_lab_task.entity.articles.LaptopEntity;
import com.kstrinadka.shift_lab_task.service.LaptopService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.LaptopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/laptop")

public class LaptopController {


    @Autowired
    LaptopService laptopService;


    @GetMapping("")
    private List<LaptopEntity> getAllLaptop()
    {
        return laptopService.getAllLaptop();
    }


    @GetMapping("/{id}")
    private LaptopEntity getLaptop(@PathVariable("id") Long id)
    {
        return laptopService.getLaptopById(id);
    }


    @DeleteMapping("/{id}")
    private void deleteLaptop(@PathVariable("id") Long id)
    {
        laptopService.delete(id);
    }


    @PostMapping("/addlist")
    @ResponseBody
    public String addLaptopList (@RequestBody List<LaptopDTO> laptopDTOList) {

        for(LaptopDTO laptopDTO: laptopDTOList){
            laptopService.saveOrUpdate(laptopDtoToEntity(laptopDTO));
        }

        return "laptop added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addLaptop (@RequestBody LaptopDTO laptopDTO) {

        laptopService.saveOrUpdate(laptopDtoToEntity(laptopDTO));

        return "hdd added to database";
    }


    @PutMapping ( "/update/{id}")
    @ResponseBody
    public LaptopDTO update(@PathVariable(name = "id") Long id, @RequestBody LaptopDTO update) {
        return laptopService.update(id, update);
    }


    private LaptopEntity laptopDtoToEntity(LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = new LaptopEntity();

        laptopEntity.setId(laptopDTO.id());
        laptopEntity.setDiagonal(laptopDTO.diagonal());
        laptopEntity.setAmount(laptopDTO.amount());
        laptopEntity.setCost(laptopDTO.cost());
        laptopEntity.setManufacturer(laptopDTO.manufacturer());
        laptopEntity.setSerial(laptopDTO.serial());
        laptopEntity.setType(laptopDTO.type());

        return laptopEntity;
    }

}
