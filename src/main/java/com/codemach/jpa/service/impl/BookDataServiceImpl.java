package com.codemach.jpa.service.impl;

import com.codemach.jpa.dto.Book;
import com.codemach.jpa.entity.AuthorData;
import com.codemach.jpa.entity.BookData;
import com.codemach.jpa.repository.AuthorDataRepository;
import com.codemach.jpa.repository.BookDataRepository;
import com.codemach.jpa.service.BookDataService;
import com.codemach.jpa.transformer.BookTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookDataServiceImpl implements BookDataService {

    private final BookDataRepository bookDataRepository;
    private final AuthorDataRepository authorDataRepository;
    private final BookTransformer bookTransformer;

    @Override
    public Book create(Book book) {
        BookData bookData = bookTransformer.toEntity(book);
        List<AuthorData> authorDataList = new ArrayList<>();
        book.getAuthorIds().forEach(id -> {
            Optional<AuthorData> optionalAuthorData = authorDataRepository.findById(id);
            if (optionalAuthorData.isPresent()) {
                AuthorData authorData = optionalAuthorData.get();
                authorDataList.add(authorData);
            }
        });
        bookData.setAuthorData(authorDataList);
        bookData = bookDataRepository.save(bookData);
        book = bookTransformer.fromEntity(bookData);
        return book;
    }

    @Override
    public Book update(Integer id, Book book) {
        book.setId(id);
        BookData bookData = bookTransformer.toEntity(book);
        List<AuthorData> authorDataList = new ArrayList<>();
        book.getAuthorIds().forEach(authorId -> {
            Optional<AuthorData> optionalAuthorData = authorDataRepository.findById(authorId);
            if (optionalAuthorData.isPresent()) {
                AuthorData authorData = optionalAuthorData.get();
                authorDataList.add(authorData);
            }
        });
        bookData.setAuthorData(authorDataList);
        bookData = bookDataRepository.save(bookData);
        book = bookTransformer.fromEntity(bookData);
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<BookData> bookDataList = bookDataRepository.findAll();
        return bookDataList
            .stream()
            .map(bookTransformer::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        bookDataRepository.deleteById(id);
    }
}
