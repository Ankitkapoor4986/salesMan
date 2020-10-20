package com.ankit.sales.model;

import lombok.Data;

@Data
public class DiscountHolder {

    private PurchaseSlab purchaseSlab;
    private int discount;
}
