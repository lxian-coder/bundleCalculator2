package com.darcy.bundlercalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Darcy Xian  4/5/21  3:39 pm      bundleCalculator
 */
@Getter
@Setter
public class FilledOrder {

    List<FilledOrderItem> filledOrderItemList = new ArrayList<>();

    @Override
    public String toString() {

        for (FilledOrderItem filledOrderItem : filledOrderItemList) {
            List<String> displayPrice = new ArrayList<>();
            BigDecimal priceSum = new BigDecimal(0);
            Map<Integer, Map<Integer, BigDecimal>> itemMap = filledOrderItem.getBundledPosts();
            List<Integer> keySet = new ArrayList<>(itemMap.keySet());
            for (Integer bundle : keySet) {
                Map<Integer, BigDecimal> calMap = itemMap.get(bundle);
                Integer cal = calMap.keySet().iterator().next();
                BigDecimal price = calMap.get(cal);
                BigDecimal bundlePrice = price.multiply(new BigDecimal(cal));
                priceSum = priceSum.add(bundlePrice);
                String s = "   " + cal + " X " + bundle + "  $" + bundlePrice;
                displayPrice.add(s);
            }
            System.out.println(filledOrderItem.getInputPosts() + " " + filledOrderItem.getFormatCode() + " $" + priceSum);
            displayPrice.forEach(System.out::println);
        }
        return null;
    }
}
