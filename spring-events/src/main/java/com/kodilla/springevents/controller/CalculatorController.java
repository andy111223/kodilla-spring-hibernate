package com.kodilla.springevents.controller;

import com.kodilla.springevents.domain.CalculatorDto;
import com.kodilla.springevents.event.CalculatorEvent;
import com.kodilla.springevents.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Autowired
    private Calculator calculator;

    @Secured("ROLE_BASIC")
    @PostMapping(path = "add")
    public void add(@RequestBody CalculatorDto calculatorDto) {
        int result = calculator.add(calculatorDto.getValue1(), calculatorDto.getValue2());
        publisher.publishEvent(new CalculatorEvent(
                this,
                "add",
                calculatorDto.getValue1(),
                calculatorDto.getValue2(),
                result
        ));
    }

    @Secured("ROLE_BASIC")
    @PostMapping(path = "sub")
    public void sub(@RequestBody CalculatorDto calculatorDto) {
        int result = calculator.sub(calculatorDto.getValue1(), calculatorDto.getValue2());
        publisher.publishEvent(new CalculatorEvent(
                this,
                "sub",
                calculatorDto.getValue1(),
                calculatorDto.getValue2(),
                result
        ));
    }

    @Secured("ROLE_BASIC")
    @PostMapping(path = "mul")
    public void mul(@RequestBody CalculatorDto calculatorDto) {
        int result = calculator.mul(calculatorDto.getValue1(), calculatorDto.getValue2());
        publisher.publishEvent(new CalculatorEvent(
                this,
                "mul",
                calculatorDto.getValue1(),
                calculatorDto.getValue2(),
                result
        ));
    }

    @Secured("ROLE_BASIC")
    @PostMapping(path = "div")
    public void div(@RequestBody CalculatorDto calculatorDto) {
        int result = calculator.div(calculatorDto.getValue1(), calculatorDto.getValue2());
        publisher.publishEvent(new CalculatorEvent(
                this,
                "div",
                calculatorDto.getValue1(),
                calculatorDto.getValue2(),
                result
        ));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
