package ua.goit.online67.fifth_example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by andreymi on 3/14/2017.
 */
public class SortTest {
    private static class Order implements Comparable<Order> {
        private String name;
        private BigDecimal price;

        public Order(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        // 1. sort price
        // 2. if prices are equals -> sort name
        @Override
        public int compareTo(Order o) {
            int priceComparision = price.compareTo(o.price);
            if (priceComparision != 0) {
                return priceComparision;
            }
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Order{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    private static class OrderComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            int res = o1.price.compareTo(o2.price);
            if (res != 0) {
                return -res;
            }//?
            return o1.name.compareTo(o2.name);
        }
    }

    public static void main(String[] args) {
        Order order1 = new Order("test1", BigDecimal.valueOf(0));
        Order order2 = new Order("test2", BigDecimal.valueOf(1));
        Order order3 = new Order("test0", BigDecimal.valueOf(4));
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        Collections.sort(orders, new OrderComparator());
        System.out.println(orders);
    }
}
