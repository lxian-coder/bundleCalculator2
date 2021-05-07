package com.darcy.bundlercalculator;

import com.darcy.bundlercalculator.calculator.Calculator;
import com.darcy.bundlercalculator.config.BundlesFormatBootstrap;

import com.darcy.bundlercalculator.model.FilledOrder;
import com.darcy.bundlercalculator.model.Order;
import com.darcy.bundlercalculator.input.UserInput;

import java.util.List;
import java.util.Map;

/**
 * Darcy Xian  4/5/21  11:20 am      bundleCalculator
 */
public class BundleCalculatorApp {
    public static void main(String[] args) {

        Map<String, Map<String, String>> bundlesFormatMap = new BundlesFormatBootstrap().createFormatsMap();

        List<String> inputList = new UserInput(bundlesFormatMap).getInputData();

        Order order = new OrderParser().parser(inputList);

        FilledOrder filledOrder = new OrderFiller(new Calculator(), bundlesFormatMap).fillTheOrder(order);

        filledOrder.toString();


    }
}
