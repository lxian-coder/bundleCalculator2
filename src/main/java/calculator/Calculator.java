package calculator;

import java.util.*;

/**
 * Darcy Xian  5/5/21  12:46 pm      bundleCalculator
 */
public class Calculator {
    public Map<Integer, Integer> getBundleBreakDownMap(int posts, List<Integer> bundles) {

        boolean calculationFaile;
        int changedPosts = posts;
        bundles.sort(Comparator.reverseOrder());
        Map<Integer, Integer> bundleBreakDownMap;
        bundleBreakDownMap = getBundleBreakdownMap(bundles, posts);
        calculationFaile = bundleBreakDownMap.containsKey(-1);
        while (calculationFaile) {
            changedPosts++;
            bundleBreakDownMap = getBundleBreakdownMap(bundles, changedPosts);
            calculationFaile = bundleBreakDownMap.containsKey(-1);
        }
        return bundleBreakDownMap;
    }

    private Map<Integer, Integer> getBundleBreakdownMap(List<Integer> descendingBundles, int posts) {
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
        int bundle = 0;
        Map<Integer, Integer> bundleBreakDownMap = new HashMap<>();
        Iterator<Integer> it = descendingBundles.iterator();

        for (int i = 0; i < descendingBundles.size(); i++) {
            bundle = it.next().intValue();
            if (postsInt / bundle > 0) {
                bundleBreakDownMap.put(bundle, postsInt / bundle);
            }
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
