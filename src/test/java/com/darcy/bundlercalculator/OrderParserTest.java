package com.darcy.bundlercalculator;

import com.darcy.bundlercalculator.model.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Darcy Xian  7/5/21  10:20 pm      bundleCalculator
 */
public class OrderParserTest {

    List<String> testList = new ArrayList<>();

    OrderParser orderParser = new OrderParser();


    @Test
    public void shouldReturnACompletedOrderGivenALegalInputList() {
        testList.add("2");
        testList.add("vid");
        testList.add("3");
        testList.add("img");

        Order order = orderParser.parser(testList);
        assertEquals(2, order.getOrderItemList().size());
        assertEquals(Integer.valueOf(2), order.getOrderItemList().get(0).getPosts());
        assertEquals("vid", order.getOrderItemList().get(0).getFormatCode());
        assertEquals(Integer.valueOf(3), order.getOrderItemList().get(1).getPosts());
        assertEquals("img", order.getOrderItemList().get(1).getFormatCode());
    }

}
