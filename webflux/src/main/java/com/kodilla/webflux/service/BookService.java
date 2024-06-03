package com.kodilla.webflux.service;

import org.springframework.stereotype.Service;
import com.kodilla.webflux.dto.BookDto;
import reactor.core.publisher.Flux;
import java.time.Duration;

@Service
public class BookService {

    public Flux<BookDto> getBooks() {
        return Flux.just(
                        new BookDto("Title1", "Author1", 2000),
                        new BookDto("Title2", "Author2", 2001),
                        new BookDto("Title3", "Author3", 2002),
                        new BookDto("Title4", "Author4", 2003),
                        new BookDto("Title5", "Author5", 2004)
                ).delayElements(Duration.ofSeconds(1))
                .log();
    }
}
