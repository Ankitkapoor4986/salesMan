package com.ankit.sales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRate implements Comparable<DiscountRate>{

    private PurchaseSlab purchaseSlab;
    private int discount;


    @Override
    public int compareTo(DiscountRate discountRate) {
        return Integer.compare(this.purchaseSlab.getMin(),discountRate.purchaseSlab.getMin());
    }
}
