package com.codemach.jpa.service;

import com.codemach.jpa.dto.Book;

import java.util.List;

public interface BookDataService {

    Book create(Book book);

    Book update(Integer id, Book book);

    List<Book> getAll();

    void delete(Integer id);

}
