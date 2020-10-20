package com.ankit.sales.service;

import com.ankit.sales.constants.CustomerType;

public interface DiscountCalculator {

    double calculateDiscount(double amount, CustomerType customerType);
}
