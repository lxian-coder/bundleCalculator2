package com.darcy.bundlercalculator.calculator;

import java.util.*;

/**
 * Darcy Xian  5/5/21  12:46 pm      bundleCalculator
 */
public class Calculator {

    public Map<Integer, Integer> getBundleBreakDownMap(int posts, List<Integer> bundles) {

        boolean calculationContinue = true;
        Map<Integer, Integer> bundleBreakDownMap = new HashMap<>();
        int changedPosts = posts;
        bundles.sort(Comparator.reverseOrder());

        while (calculationContinue) {
            changedPosts++;
            bundleBreakDownMap = getBundleBreakdownHelper(bundles, changedPosts);
            calculationContinue = bundleBreakDownMap.containsKey(-1);
        }
        return bundleBreakDownMap;
    }

    private Map<Integer, Integer> getBundleBreakdownHelper(List<Integer> descendingBundles, int posts) {
        int bundlesSize = descendingBundles.size();
        Map<Integer, Integer> bundleBreakDownMap = new HashMap<>();
        Iterator<Integer> it = descendingBundles.iterator();
        List<Integer> copyDescendingBundles = new ArrayList<>(descendingBundles);

        for (int i = 0; i < bundlesSize - 1; i++) {
            bundleBreakDownMap = getBundleBreakdownMapCalculator(copyDescendingBundles, posts);
            if (bundleBreakDownMap.containsKey(-1)) {
                Integer maxBundles = it.next();
                copyDescendingBundles.remove(maxBundles);
            } else {
                return bundleBreakDownMap;
            }
        }
        return bundleBreakDownMap;
    }

    private Map<Integer, Integer> getBundleBreakdownMapCalculator(List<Integer> descendingBundles, int posts) {
        int postsInt = posts;
        int bundle;
        Map<Integer, Integer> bundleBreakDownMap = new HashMap<>();
        Iterator<Integer> it = descendingBundles.iterator();

        for (int i = 0; i < descendingBundles.size(); i++) {
            bundle = it.next();
            if (postsInt / bundle > 0) bundleBreakDownMap.put(bundle, postsInt / bundle);
            if (postsInt % bundle == 0) {
                postsInt = 0;
                break;
            } else {
                postsInt = postsInt % bundle;
            }
        }
        if (postsInt != 0) {
            int wrong = -1;
            bundleBreakDownMap = new HashMap<>();
            bundleBreakDownMap.put(wrong, postsInt);
            return bundleBreakDownMap;
        }
        return bundleBreakDownMap;
    }
}
