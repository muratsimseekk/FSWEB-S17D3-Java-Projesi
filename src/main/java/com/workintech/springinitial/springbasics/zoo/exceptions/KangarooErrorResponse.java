package com.workintech.springinitial.springbasics.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KangarooErrorResponse {
    private int status;
    private String message;
    private LocalDateTime createdAt;
}
