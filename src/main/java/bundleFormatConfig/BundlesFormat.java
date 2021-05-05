package bundleFormatConfig;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * Darcy Xian  4/5/21  3:46 pm      bundleCalculator
 */
@Getter
@Setter
public class BundlesFormat {
    String formatName;
    String formatCode;
    HashMap<String, String> bundles = new HashMap<>();
}
