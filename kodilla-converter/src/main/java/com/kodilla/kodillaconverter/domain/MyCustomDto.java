package com.kodilla.kodillaconverter.domain;

public class MyCustomDto {

    private final String fieldOne;
    private final String fieldTwo;
    private final String fieldThree;


    public MyCustomDto(String fieldOne, String fieldTwo, String fieldThree) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.fieldThree = fieldThree;
    }

    public String getFieldOne() {
        return fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public String getFieldThree() {
        return fieldThree;
    }
}
