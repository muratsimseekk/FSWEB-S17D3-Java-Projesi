package com.workintech.springinitial.springbasics.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Koala {
    private Integer id;
    private String name;
    private Double weight;
    private Double sleepHour;
    private Gender gender;
}
