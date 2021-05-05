import model.Order;
import model.OrderItem;

import java.util.List;

/**
 * Darcy Xian  4/5/21  3:40 pm      bundleCalculator
 */

public class OrderParser {

    public Order parser(List<String> inputList) {
        Order order = new Order();
        int posts = 0;

        for (int i = 0; i < inputList.size(); i++) {
            if (i % 2 == 0) {
                posts = Integer.parseInt(inputList.get(i));
            } else {
                OrderItem orderItem = new OrderItem();
                orderItem.setPosts(posts);
                orderItem.setFormatCode(inputList.get(i));
                order.getOrderItemList().add(orderItem);
            }
        }
        return order;
    }
}

