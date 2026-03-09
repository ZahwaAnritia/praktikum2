package com.example.praktikum2.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse<T> {
    private String status;
    private String message;
    private T data;
}