package com.kstrinadka.shift_lab_task.controllers;



import com.kstrinadka.shift_lab_task.entity.articles.PcEntity;
import com.kstrinadka.shift_lab_task.service.PcService;
import com.kstrinadka.shift_lab_task.transferLayer.articles.PcDTO;
import com.sun.xml.bind.v2.runtime.output.Pcdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/pc")
public class PcController {



    @Autowired
    PcService pcService;


    @GetMapping("")
    private List<PcEntity> getAllPc()
    {
        return pcService.getAllPc();
    }


    @GetMapping("/{id}")
    private PcEntity getPc(@PathVariable("id") Long id)
    {
        return pcService.getPcById(id);
    }

    //creating a delete mapping that deletes a specific pc
    @DeleteMapping("/{id}")
    private void deletePc(@PathVariable("id") Long id)
    {
        pcService.delete(id);
    }


    @PostMapping("/addlist")
    @ResponseBody
    public String addPcList (@RequestBody List<PcDTO> pcDTOList) {

        for(PcDTO pcDTO: pcDTOList){
            pcService.saveOrUpdate((pcDtoToEntity(pcDTO)));
        }

        return "pc added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addPc (@RequestBody PcDTO pcDTO) {

        pcService.saveOrUpdate(pcDtoToEntity(pcDTO));

        return "pc added to database";
    }


    @PutMapping ( "/update/{id}")
    @ResponseBody
    public PcDTO update(@PathVariable(name = "id") Long id, @RequestBody PcDTO update) {
        return pcService.update(id, update);
    }

    private PcEntity pcDtoToEntity(PcDTO pcDTO){
        PcEntity pcEntity = new PcEntity();

        pcEntity.setId(pcDTO.id());
        pcEntity.setPcType(pcDTO.pcType());
        pcEntity.setAmount(pcDTO.amount());
        pcEntity.setCost(pcDTO.cost());
        pcEntity.setManufacturer(pcDTO.manufacturer());
        pcEntity.setSerial(pcDTO.serial());
        pcEntity.setType(pcDTO.type());

        return pcEntity;
    }

}
