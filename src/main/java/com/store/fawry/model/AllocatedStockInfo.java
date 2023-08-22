package com.store.fawry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllocatedStockInfo {
    @JsonProperty("product_code")
    private String productCode;
    @JsonProperty("allocated_quantity")
    private int allocatedQuantity;
}
