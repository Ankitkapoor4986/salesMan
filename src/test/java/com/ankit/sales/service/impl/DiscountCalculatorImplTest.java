package com.ankit.sales.service.impl;

import com.ankit.sales.constants.CustomerType;
import com.ankit.sales.service.DiscountCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorImplTest {

    @Test
    public void shouldCalculateDiscountFor100(){
        DiscountCalculator discountCalculator = new DiscountCalculatorImpl();
        double discount = discountCalculator.calculateDiscount(100, CustomerType.Regular);
        Assertions.assertEquals(0.0,discount);
    }

    @Test
    public void shouldCalculateDiscountFor100ForPremium(){
        DiscountCalculator discountCalculator = new DiscountCalculatorImpl();
        double discount = discountCalculator.calculateDiscount(100, CustomerType.Premium);
        Assertions.assertEquals(10.0,discount);
    }

    @Test
    public void shouldCalculateDiscountFor1MiddleSlab(){
        DiscountCalculator discountCalculator = new DiscountCalculatorImpl();
        double discount = discountCalculator.calculateDiscount(6000, CustomerType.Premium);
        Assertions.assertEquals(700.0,discount);
    }






}