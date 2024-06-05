package com.kodilla.kodillajms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void placeOrder(@RequestBody Order order) {
        jmsTemplate.convertAndSend("orderQueue", order);
    }
}