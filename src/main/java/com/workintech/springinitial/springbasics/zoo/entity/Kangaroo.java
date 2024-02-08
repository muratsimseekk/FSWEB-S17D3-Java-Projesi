package com.workintech.springinitial.springbasics.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kangaroo {
    private Integer id;
    private String name;
    private Double height;
    private Double weight;
    private Gender gender;
    private Boolean isAggressive;
}
