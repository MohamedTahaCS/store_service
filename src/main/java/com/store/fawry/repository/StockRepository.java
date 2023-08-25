package com.store.fawry.repository;

import com.store.fawry.model.Stock;
import com.store.fawry.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
    List<Stock> findByStore_Code(String storeCode);
    List<Stock> findByStore(Store store);

    List<Stock> findByProductCode(String productCode);

    List<Stock> findByStore_CodeAndProductCode(String StoreCode, String productCode);
    List<Stock> findByStoreAndProductCode(Store store, String productCode);

    void deleteAllByStore_Code(String storeCode);

    boolean existsByStore_CodeAndProductCode(String storeCode, String productCode);
}