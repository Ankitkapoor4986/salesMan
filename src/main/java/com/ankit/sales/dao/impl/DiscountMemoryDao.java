package com.ankit.sales.dao.impl;

import com.ankit.sales.constants.CustomerType;
import com.ankit.sales.dao.DiscountDao;
import com.ankit.sales.model.DiscountRate;
import com.ankit.sales.model.PurchaseSlab;

import java.util.List;
import java.util.Map;

public class DiscountMemoryDao implements DiscountDao {


    public Map<CustomerType,List<DiscountRate>> findAllDiscountRates() {
        return Map.of(CustomerType.Regular,
                List.of(new DiscountRate(new PurchaseSlab(0,5000),0),
                        new DiscountRate(new PurchaseSlab(5000,10000),10),
                        new DiscountRate(new PurchaseSlab(10000,Integer.MAX_VALUE),20))
                ,
                CustomerType.Premium,
                List.of(new DiscountRate(new PurchaseSlab(0,4000),10),
                        new DiscountRate(new PurchaseSlab(4000,8000),15),
                        new DiscountRate(new PurchaseSlab(8000,12000),20),
                        new DiscountRate(new PurchaseSlab(12000,Integer.MAX_VALUE),30))
                );
    }
}
