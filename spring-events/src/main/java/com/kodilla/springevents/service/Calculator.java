package com.kodilla.springevents.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int add(int value1, int value2) {
        return value1 + value2;
    }

    public int sub(int value1, int value2) {
        return value1 - value2;
    }

    public int mul(int value1, int value2) {
        return value1 * value2;
    }

    public int div(int value1, int value2) {
        if (value2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return value1 / value2;
    }
}
