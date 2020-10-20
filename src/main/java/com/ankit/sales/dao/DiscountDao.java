package com.ankit.sales.dao;

import com.ankit.sales.constants.CustomerType;
import com.ankit.sales.model.DiscountRate;

import java.util.List;
import java.util.Map;

public interface DiscountDao {

    Map<CustomerType, List<DiscountRate>> findAllDiscountRates();
}
