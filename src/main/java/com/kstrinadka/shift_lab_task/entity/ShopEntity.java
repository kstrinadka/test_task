package com.kstrinadka.shift_lab_task.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCTS_TABLE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String type;

    @Column
    private String serial;

    @Column
    private String manufacturer;

    @Column
    private String cost;

    @Column
    private String amount;

}
