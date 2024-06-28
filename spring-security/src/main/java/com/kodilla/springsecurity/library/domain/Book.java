package com.kodilla.springsecurity.library.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Book {
    String title;
    String author;
    int year;
}
