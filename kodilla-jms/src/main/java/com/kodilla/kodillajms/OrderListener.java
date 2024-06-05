package com.kodilla.kodillajms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @JmsListener(destination = "orderQueue")
    public void receiveOrder(Order order) {
        System.out.println("Received order: " + order.getOrderId() + " for product: " + order.getProduct());
    }
}