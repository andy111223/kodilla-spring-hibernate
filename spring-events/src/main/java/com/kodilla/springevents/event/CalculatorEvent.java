package com.kodilla.springevents.event;

import org.springframework.context.ApplicationEvent;

public class CalculatorEvent extends ApplicationEvent {

    private final String endpoint;
    private final int value1;
    private final int value2;
    private final int result;

    public CalculatorEvent(Object source, String endpoint, int value1, int value2, int result) {
        super(source);
        this.endpoint = endpoint;
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getResult() {
        return result;
    }
}
