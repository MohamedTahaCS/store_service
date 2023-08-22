package com.store.fawry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductAvailabilityResponse {
    private boolean available;
    @JsonProperty("available_quantity")
    private int availableQuantity;
}
