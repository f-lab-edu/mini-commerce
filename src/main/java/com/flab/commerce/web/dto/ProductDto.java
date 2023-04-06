package com.flab.commerce.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String category;

    private String productName;

    private Integer price;

    private String description;
}
