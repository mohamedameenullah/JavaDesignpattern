package com.ameen.dp.proxy;

import java.util.Arrays;
import java.util.List;

public class Structural_ProxyExample_Customer_Order {
    public static void main(String[] args) {
        Customer customer = new CustomerProxy();
        System.out.println(customer.getId() + "  " + customer.getOrders());
    }
}

class Order {
    int orderId;
    String productName;
    int quantity;

    public Order(int orderId, String productName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

interface Customer {
    int getId();
    List<Order> getOrders();

}

class CustomerImpl implements Customer {
    int customerId;
    List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", orderList=" + orderList +
                '}';
    }

    @Override
    public int getId() {
        return 33;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }
}

class CustomerProxy implements Customer {
    Customer c = new CustomerImpl();

    @Override
    public int getId() {
        return c.getId();
    }

    @Override
    public List<Order> getOrders() {
        Order o1 = new Order(1, "Mobile", 20);
        Order o2 = new Order(2, "Laptop", 10);
        Order o3 = new Order(3, "TV", 5);
        Order o4 = new Order(4, "Fridge", 35);
        List<Order> orders = Arrays.asList(o1, o2, o3, o4);
        return orders;
    }
}
