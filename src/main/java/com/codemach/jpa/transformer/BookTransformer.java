package com.codemach.jpa.transformer;

import com.codemach.jpa.dto.Author;
import com.codemach.jpa.dto.Book;
import com.codemach.jpa.entity.AuthorData;
import com.codemach.jpa.entity.BookData;
import com.codemach.jpa.repository.AuthorDataRepository;
import com.codemach.jpa.service.AuthorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class BookTransformer {

    private final AuthorDataRepository authorDataRepository;

    public Book fromEntity(BookData bookData) {
        Book book = new Book();
        book.setId(bookData.getId());
        book.setName(bookData.getName());
        book.setPrice(bookData.getPrice());
        List<Integer> ids = bookData.getAuthorData()
            .stream()
            .map(AuthorData::getId).collect(Collectors.toList());
        book.setAuthorIds(ids);
        return book;
    }

    public BookData toEntity(Book book) {
        BookData bookData = new BookData();
        bookData.setId(book.getId());
        bookData.setName(book.getName());
        bookData.setPrice(book.getPrice());
        return bookData;
    }
}
