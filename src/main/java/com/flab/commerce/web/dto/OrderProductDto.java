package com.flab.commerce.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {

    private String productName;

    private Integer count;

    private Integer totalPrice;

}
