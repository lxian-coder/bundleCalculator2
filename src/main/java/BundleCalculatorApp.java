import bundleFormatConfig.BundlesFormatBootstrap;
import calculator.Calculator;
import model.FilledOrder;
import model.Order;
import userInput.UserInput;

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
