package com.kodilla.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @Secured("ROLE_ADVANCED")
    @GetMapping(value = "/strings", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .map(s -> "{\"value\":\"" + s + "\"}")
                .log();
    }
}
