package com.store.fawry.controller;

import com.store.fawry.model.Store;
import com.store.fawry.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    public final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    @GetMapping({"/", ""})
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping({"/{code}"})
    public ResponseEntity<Store> getStoreById(@PathVariable String code) {
        Store store = storeService.getStoreByCode(code);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Store> createNewStore(@RequestBody Store store) {
        Store newStore = storeService.createNewStore(store);
        return new ResponseEntity<>(newStore, HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<Store> updateStore(@RequestBody Store store) {
        Store updatedStore = storeService.updateStore(store);
        return new ResponseEntity<>(updatedStore, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteStore(@PathVariable String code) {
        storeService.deleteStore(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
