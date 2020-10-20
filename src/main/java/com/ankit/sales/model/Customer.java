package com.ankit.sales.model;

import com.ankit.sales.constants.CustomerType;
import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private String name;
    private CustomerType customerType;
    private Order currentOrder;
    private List<Order> previousOrders;
}
