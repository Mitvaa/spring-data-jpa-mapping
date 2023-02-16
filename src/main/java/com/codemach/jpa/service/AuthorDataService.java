package com.codemach.jpa.service;

import com.codemach.jpa.dto.Author;

import java.util.List;

public interface AuthorDataService {

    Author create(Author author);

    Author update(Integer id, Author author);

    List<Author> getAll();

    void delete(Integer id);
}
