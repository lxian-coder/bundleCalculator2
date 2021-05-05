package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Darcy Xian  4/5/21  11:24 am      bundleCalculator
 */
@Setter
@Getter
public class Order {
    List<OrderItem> orderItemList = new ArrayList<>();


}
