package com.ankit.sales.service.impl;

import com.ankit.sales.constants.CustomerType;
import com.ankit.sales.dao.impl.DiscountMemoryDao;
import com.ankit.sales.model.DiscountRate;
import com.ankit.sales.service.DiscountCalculator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountCalculatorImpl implements DiscountCalculator {

    private final Map<CustomerType, List<DiscountRate>> discountRatesMappedByCustomerType =
            DiscountMemoryDao.getInstance().findAllDiscountRates();

    @Override
    public double calculateDiscount(double amount, CustomerType customerType) {
        List<DiscountRate> discountRatesForCustomer = discountRatesMappedByCustomerType.get(customerType);
        List<DiscountRate> discountRates = discountRatesForCustomer.stream()
                .filter(discountRate -> discountRate.getPurchaseSlab().getMin() < amount)
                .collect(Collectors.toList());

        int discount = discountRates.stream().mapToInt(discountRate ->
                ((discountRate.getPurchaseSlab().getMax() * discountRate.getDiscount())
                        / 100)).sum();
        Double addionalDiscount = calculateAdditionalDiscount(amount, discountRates);
        return discount + addionalDiscount;
    }

    private Double calculateAdditionalDiscount(double amount, List<DiscountRate> discountRates) {
        Optional<DiscountRate> maximumDiscountRate = discountRates.stream().
                max(Comparator.comparingInt(discountRate -> discountRate.getPurchaseSlab().getMax()));

        return maximumDiscountRate
                .filter(maxDisRate -> maxDisRate.getPurchaseSlab().getMax() < amount)
                .map(maxDisRate -> getAdditionalDiscount(amount, maxDisRate)).orElse(0.0);

    }

    private Double getAdditionalDiscount(double amount, DiscountRate maxDisRate) {
        double amountGreaterThanMax = (amount - maxDisRate.getPurchaseSlab().getMax());
        return (amountGreaterThanMax * maxDisRate.getDiscount()) / 100;
    }
}
