package com.ankit.sales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRate {

    private PurchaseSlab purchaseSlab;
    private int discount;
}
