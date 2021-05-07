package com.darcy.bundlercalculator;

import com.darcy.bundlercalculator.calculator.Calculator;
import lombok.RequiredArgsConstructor;
import com.darcy.bundlercalculator.model.FilledOrder;
import com.darcy.bundlercalculator.model.FilledOrderItem;
import com.darcy.bundlercalculator.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Darcy Xian  4/5/21  11:23 am      bundleCalculator
 */
@RequiredArgsConstructor
public class OrderFiller {
    private final Calculator calculator;
    private final Map<String, Map<String, String>> bundlesFormatMap;

    public FilledOrder fillTheOrder(Order order) {
        FilledOrder filledOrder = new FilledOrder();

        order.getOrderItemList().forEach(orderItem -> {
            String formatCode = orderItem.getFormatCode();
            List<Integer> bundlesSet = bundlesFormatMap.get(formatCode).keySet()
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Map<Integer, Integer> bundleBreakDownMap = calculator.getBundleBreakDownMap(orderItem.getPosts(), bundlesSet);
            Map<Integer, Map<Integer, BigDecimal>> bundledPosts = addPriceToBundleBreakDownMap(bundleBreakDownMap, formatCode);
            FilledOrderItem filledOrderItem = new FilledOrderItem();
            filledOrderItem.setBundledPosts(bundledPosts);
            filledOrderItem.setInputPosts(orderItem.getPosts());
            filledOrderItem.setFormatCode(formatCode);
            filledOrder.getFilledOrderItemList().add(filledOrderItem);
        });

        return filledOrder;
    }

    private Map<Integer, Map<Integer, BigDecimal>> addPriceToBundleBreakDownMap(Map<Integer, Integer> bundleBreakMap, String formatCode) {
        Map<Integer, Map<Integer, BigDecimal>> resultMap = new HashMap<>();
        List<String> bundles = new ArrayList<>(bundlesFormatMap.get(formatCode).keySet());

        bundles.forEach(bundle -> {
            Map<Integer, BigDecimal> subMap = new HashMap<>();
            String stringPrice = bundlesFormatMap.get(formatCode).get(bundle);
            BigDecimal price = new BigDecimal(stringPrice);
            Integer intBundle = Integer.parseInt(bundle);
            Integer cal = bundleBreakMap.get(intBundle);
            if (cal != null) {
                subMap.put(bundleBreakMap.get(intBundle), price);
                resultMap.put(intBundle, subMap);
            }
        });

        return resultMap;

    }


}
