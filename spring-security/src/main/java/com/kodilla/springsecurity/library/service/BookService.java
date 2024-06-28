package com.kodilla.springsecurity.library.service;

import com.kodilla.springsecurity.library.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();
    void createBook(Book book);
    void deleteBook(int index);
}
