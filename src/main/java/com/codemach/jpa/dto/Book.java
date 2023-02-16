package com.codemach.jpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Integer id;
    private String name;
    private Double price;
    private List<Integer> authorIds;
}
