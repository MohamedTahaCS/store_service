package com.store.fawry.service;

import com.store.fawry.model.Stock;
import com.store.fawry.model.StockActionType;
import com.store.fawry.model.StockHistory;

import java.util.List;

public interface StockHistoryService {
    List<StockHistory> getAllStockHistories();

    List<StockHistory> getHistoryOfProductInStore(String storeCode, String productCode);

    List<StockHistory> getHistoryOfProduct(String productCode);

    List<StockHistory> getHistoryOfStore(String storeCode);

    void createStockHistory(Stock stock, int previousQuantity, int newQuantity, StockActionType actionType);
}
