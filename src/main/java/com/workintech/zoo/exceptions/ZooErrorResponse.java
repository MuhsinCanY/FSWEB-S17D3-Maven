package com.workintech.zoo.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZooErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
