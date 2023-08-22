package com.store.fawry.service;

import com.store.fawry.model.Store;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StoreService {
    List<Store> getAllStores();

    Store getStoreByCode(String code);

    Store createNewStore(Store store);

    @Transactional
    Store updateStore(Store store);

    @Transactional
    void deleteStore(String code);
}
