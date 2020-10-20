package com.ankit.sales.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private double amount;
    private List<Item> items;
}
