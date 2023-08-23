package com.store.fawry.controller;

import com.store.fawry.model.*;
import com.store.fawry.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")

public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Stock>> getAllStocks() {
        var stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public Stock getStockByCode(@PathVariable String code) {
        return stockService.getStockByCode(code);
    }

    @GetMapping("/store/{code}")
    public ResponseEntity<List<Stock>> getStocksByStoreCode(@PathVariable String code) {
        var stocks = stockService.getStocksByStoreCode(code);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/store/{storeCode}/product/{productCode}")
    public ResponseEntity<Stock> getStockByStoreAndProduct(
            @PathVariable String storeCode,
            @PathVariable String productCode) {
        var stock = stockService.getStockByStoreCodeAndProductCode(storeCode, productCode);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping("/increase")
    public ResponseEntity<?> increaseStock(@RequestBody StockRequest stockRequest) {
        if (!stockRequest.valid()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("store_code and product_code should be Not Null.");
        }

        stockService.increaseStockQuantity(stockRequest);
        return ResponseEntity.ok("Stock quantity increased successfully.");
    }

    @PostMapping("/decrease")
    public ResponseEntity<?> decreaseStock(@RequestBody StockRequest stockRequest) {
        if (!stockRequest.valid()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("store_code and product_code should be Not Null.");
        }

        stockService.decreaseStockQuantity(stockRequest);
        return ResponseEntity.ok("Stock quantity decreased successfully.");
    }

    @GetMapping("/check_availability")
    public ResponseEntity<ProductAvailabilityResponse> checkStockAvailability(
            @RequestBody ProductRequest productRequest) {
        ProductAvailabilityResponse response = stockService.checkStockAvailability(productRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/make_order")
    public ResponseEntity<List<AllocatedStoreInfo>> makeOrder(@RequestBody List<ProductRequest> productRequests) {
        List<AllocatedStoreInfo> allocatedStoreInfos = stockService.makeOrder(productRequests);
        return ResponseEntity.ok(allocatedStoreInfos);
    }

}
