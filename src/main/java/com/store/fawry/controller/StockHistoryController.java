package com.store.fawry.controller;

import com.store.fawry.model.StockHistory;
import com.store.fawry.service.StockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-history")
public class StockHistoryController {
    private final StockHistoryService stockHistoryService;

    @Autowired
    public StockHistoryController(StockHistoryService stockHistoryService) {
        this.stockHistoryService = stockHistoryService;
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<StockHistory>> getAllStockHistories() {
        var stockHistories = stockHistoryService.getAllStockHistories();
        return new ResponseEntity<>(stockHistories, HttpStatus.OK);
    }

    @GetMapping("/store/{code}")
    public ResponseEntity<List<StockHistory>> getHistoryOfStore(@PathVariable String code) {
        var stockHistories = stockHistoryService.getHistoryOfStore(code);
        return new ResponseEntity<>(stockHistories, HttpStatus.OK);
    }

    @GetMapping("/product/{productCode}")
    public ResponseEntity<List<StockHistory>> getHistoryOfProduct(@PathVariable String productCode) {
        var stockHistories = stockHistoryService.getHistoryOfProduct(productCode);
        return new ResponseEntity<>(stockHistories, HttpStatus.OK);
    }

    @GetMapping("/store/{storeCode}/product/{productCode}")
    public ResponseEntity<List<StockHistory>> getHistoryOfProductInStore(@PathVariable String storeCode,
            @PathVariable String productCode) {
        var stockHistories = stockHistoryService.getHistoryOfProductInStore(storeCode, productCode);
        return new ResponseEntity<>(stockHistories, HttpStatus.OK);
    }

}
