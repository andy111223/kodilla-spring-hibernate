package com.kodilla.springevents.service;

import com.kodilla.springevents.event.CalculatorEvent;
import org.springframework.context.ApplicationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculatorListener implements ApplicationListener<CalculatorEvent> {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorListener.class);

    @Override
    public void onApplicationEvent(CalculatorEvent event) {

        logger.info("Endpoint: " + event.getEndpoint());
        logger.info("Value1: " + event.getValue1());
        logger.info("Value2: " + event.getValue2());
        logger.info("Result: " + event.getResult());
    }
}
