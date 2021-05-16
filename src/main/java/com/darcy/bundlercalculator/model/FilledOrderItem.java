package com.darcy.bundlercalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Darcy Xian  4/5/21  5:14 pm      bundleCalculator
 */
@Getter
@Setter
public class FilledOrderItem {
    private String formatCode;
    private int inputPosts;
    private Map<Integer, Map<Integer, BigDecimal>> bundledPosts;

    @Override
    public String toString() {
        List<Integer> keyList = new ArrayList<>(bundledPosts.keySet());
        BigDecimal priceSum = new BigDecimal(0);
        List<String> displayPrice = new ArrayList<>();
        for (Integer key : keyList) {
            Map<Integer, BigDecimal> itemMap = bundledPosts.get(key);
            Integer quality = itemMap.keySet().iterator().next();
            BigDecimal price = itemMap.get(quality);
            priceSum = priceSum.add(price);
            String s = "   " + quality + " X " + key + "  $" + price;
            displayPrice.add(s);
        }
        System.out.println(inputPosts + " " + formatCode + " $" + priceSum);
        displayPrice.forEach(System.out::println);
        return null;
    }
}
