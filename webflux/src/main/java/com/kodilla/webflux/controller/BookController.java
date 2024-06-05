package com.kodilla.webflux.controller;

import com.kodilla.webflux.dto.BookDto;
import com.kodilla.webflux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Secured("ROLE_ADVANCED")
    @GetMapping(value = "/books", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BookDto> getBooks() {
        return bookService.getBooks();
    }
}
