package com.kstrinadka.shift_lab_task.transferLayer;


import javax.persistence.Column;

public record ShopDTO(Long id, String type, String serial, String manufacturer,
                      String cost, String amount) {

}
