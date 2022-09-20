package com.kstrinadka.shift_lab_task.transferLayer.articles;

public record PcDTO(Long id, String type, String serial, String manufacturer,
                    String cost, String amount, String pcType) {
}
