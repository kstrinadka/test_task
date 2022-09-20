package com.kstrinadka.shift_lab_task.transferLayer.articles;

public record ScreenDTO(Long id, String type, String serial, String manufacturer,
                        String cost, String amount, String diagonal) {
}
