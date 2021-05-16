package com.darcy.bundlercalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Darcy Xian  4/5/21  3:39 pm      bundleCalculator
 */
@Getter
@Setter
public class FilledOrder {

    List<FilledOrderItem> filledOrderItemList = new ArrayList<>();

    @Override
    public String toString() {

        filledOrderItemList.forEach(filledOrderItem -> filledOrderItem.toString());
        return null;
    }
}
