package com.darcy.bundlercalculator.calculator;

import manifold.ext.rt.api.Jailbreak;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Darcy Xian  7/5/21  2:15 pm      bundleCalculator
 */

public class CalculatorTest {
    List<Integer> descendingBundles = new ArrayList<>();

    @Jailbreak
    Calculator calculator = new Calculator();

    @BeforeEach
    public void setup() {
        descendingBundles.add(3);
        descendingBundles.add(6);
        descendingBundles.add(9);
        descendingBundles.add(14);
        descendingBundles.sort(Comparator.reverseOrder());
    }

    @Test
    public void shouldReturnFailedMapGivenCalculationFailed() {
        int posts = 4;
        Map<Integer, Integer> result = calculator.getBundleBreakdownMapCalculator(descendingBundles, posts);
        assertTrue(result.containsKey(-1));
        assertEquals(1, result.get(-1));
    }

    @Test
    public void shouldReturnSuccessMapGivenPostsBundledSuccessfully() {
        int posts = 12;
        Map<Integer, Integer> testResult = calculator.getBundleBreakdownMapCalculator(descendingBundles, posts);

        assertTrue(testResult.containsKey(9));
        assertEquals(1, testResult.get(9));

        assertTrue(testResult.containsKey(3));
        assertEquals(1, testResult.get(3));

        assertFalse(testResult.containsKey(14));
        assertFalse(testResult.containsKey(6));
    }

    @Test
    public void shouldReturnSuccessMapGivenPostsIsBigButCanOnlyBeBundledBySmallTwoBundles() {
        int posts = 15;
        Map<Integer, Integer> testResult = calculator.getBundleBreakdownHelper(descendingBundles, posts);

        assertTrue(testResult.containsKey(6));
        assertEquals(1, testResult.get(6));

        assertTrue(testResult.containsKey(9));
        assertEquals(1, testResult.get(6));

        assertFalse(testResult.containsKey(14));
        assertFalse(testResult.containsKey(3));
    }

    @Test
    public void shouldReturnSuccessMapEventuallyGivenPostsCanNotBeBundled() {
        int posts = 4;
        Map<Integer, Integer> testResult = calculator.getBundleBreakDownMap(posts, descendingBundles);

        assertTrue(testResult.containsKey(6));
        assertEquals(1, testResult.get(6));

        assertFalse(testResult.containsKey(9));
        assertFalse(testResult.containsKey(14));
        assertFalse(testResult.containsKey(3));
    }


}




























