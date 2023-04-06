package com.flab.commerce.web.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private String orderNumber;

    private List<OrderProductDto> products;

    private String status;

    private Integer totalPrice;

}
