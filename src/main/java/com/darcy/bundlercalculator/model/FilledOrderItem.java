package com.darcy.bundlercalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
}
