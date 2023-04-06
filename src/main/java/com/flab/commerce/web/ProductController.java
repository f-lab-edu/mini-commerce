package com.flab.commerce.web;

import com.flab.commerce.web.dto.ProductDto;
import com.flab.commerce.web.dto.ProductSearch;
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

@Tag(name = "Product Controller", description = "상품 컨트롤러")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Operation(operationId = "productCreate", summary = "제품 등록", description = "제품을 등록한다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "CREATED",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
    })
    @PostMapping
    public ResponseEntity<ProductDto> create(
        @Parameter(required = true, description = "제품 정보") ProductDto product) {
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Operation(operationId = "productUpdate", summary = "제품 정보 수정", description = "제품 정보 수정")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "CREATED",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
    })
    @PostMapping("/{productId}/edit")
    public ResponseEntity<ProductDto> updateProduct(
        @Parameter(required = true, description = "제품 ID") @PathVariable("productId") Long productId,
        @Parameter(required = true, description = "제품 정보") ProductDto product) {
        return  ResponseEntity.ok(product);
    }

    @Operation(operationId = "productList", summary = "제품 리스트 조회", description = "제품 리스트를 조회 한다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))),
    })
    @GetMapping
    public ResponseEntity<List<ProductDto>> list(
        @Parameter(required = true, description = "제품 검색 조건") ProductSearch productSearch) {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @Operation(operationId = "getProduct", summary = "제품 상세 조회", description = "제품을 상세 조회 한다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
    })
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(
        @Parameter(required = true, description = "제품 ID") @PathVariable("productId") Long productId) {
        return ResponseEntity.ok(new ProductDto());
    }
}
