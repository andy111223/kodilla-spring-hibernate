package com.kodilla.springevents.domain;

public class CalculatorDto {

    private int value1;
    private int value2;

    public CalculatorDto(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
}
