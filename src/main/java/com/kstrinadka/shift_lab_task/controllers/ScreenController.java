package com.kstrinadka.shift_lab_task.controllers;



import com.kstrinadka.shift_lab_task.entity.articles.ScreenEntity;
import com.kstrinadka.shift_lab_task.service.ScreenService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.ScreenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/screen")
public class ScreenController {


    @Autowired
    ScreenService screenService;


    @GetMapping("")
    private List<ScreenEntity> getAllScreen()
    {
        return screenService.getAllScreen();
    }


    @GetMapping("/{id}")
    private ScreenEntity getScreen(@PathVariable("id") Long id)
    {
        return screenService.getScreenById(id);
    }


    @DeleteMapping("/{id}")
    private void deleteScreen(@PathVariable("id") Long id)
    {
        screenService.delete(id);
    }


    @PostMapping("/addlist")
    @ResponseBody
    public String addScreenList (@RequestBody List<ScreenDTO> screenDTOList) {

        for(ScreenDTO screenDTO: screenDTOList){
            screenService.saveOrUpdate(screenDtoToEntity(screenDTO));
        }

        return "hdd added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addScreen (@RequestBody ScreenDTO screenDTO) {

        screenService.saveOrUpdate(screenDtoToEntity(screenDTO));

        return "hdd added to database";
    }


    @PutMapping ( "/update/{id}")
    @ResponseBody
    public ScreenDTO update(@PathVariable(name = "id") Long id, @RequestBody ScreenDTO update) {
        return screenService.update(id, update);
    }


    private ScreenEntity screenDtoToEntity(ScreenDTO screenDTO){
        ScreenEntity screenEntity = new ScreenEntity();

        screenEntity.setId(screenDTO.id());
        screenEntity.setDiagonal(screenDTO.diagonal());
        screenEntity.setAmount(screenDTO.amount());
        screenEntity.setCost(screenDTO.cost());
        screenEntity.setManufacturer(screenDTO.manufacturer());
        screenEntity.setSerial(screenDTO.serial());
        screenEntity.setType(screenDTO.type());

        return screenEntity;
    }
}
