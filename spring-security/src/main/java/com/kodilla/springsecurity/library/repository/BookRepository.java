package com.kodilla.springsecurity.library.repository;

import com.kodilla.springsecurity.library.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();
    void save(Book book);
    void deleteByIndex(int index);
}
