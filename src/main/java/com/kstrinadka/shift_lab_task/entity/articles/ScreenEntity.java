package com.kstrinadka.shift_lab_task.entity.articles;


import com.kstrinadka.shift_lab_task.entity.ShopEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SCREEN_TABLE")
@Data
public class ScreenEntity extends ShopEntity {

    @Column(name = "diagonal")
    private String diagonal;

}
