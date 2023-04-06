package com.flab.commerce.web;

import com.flab.commerce.web.dto.OrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order Controller", description = "주문 컨트롤러")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Operation(operationId = "orderCreate", summary = "주문 생성", description = "주문을 한다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "CREATED",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDto.class))),
    })
    @PostMapping
    public ResponseEntity<OrderDto> create(
        @Parameter(required = true, description = "주문 정보") OrderDto order) {
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @Operation(operationId = "getOrder", summary = "주문 상세 조회", description = "하나의 주문을 상세 조회 한다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDto.class))),
    })
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(
            @PathVariable("orderId") @Parameter(required = true, description = "주문 ID") Long orderId) {
        return ResponseEntity.ok(new OrderDto());
    }

    @Operation(operationId = "getUserOrders", summary = "유저 주문 조회", description = "유저의 주문 들을 조회 한다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderDto.class)))),
    })
    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderDto>> getUserOrders(
            @PathVariable("userId") @Parameter(required = true, description = "유저 ID") Long userId) {
        return ResponseEntity.ok(new ArrayList<>());
    }


}
