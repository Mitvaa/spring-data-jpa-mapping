package com.codemach.jpa.controller;

import com.codemach.jpa.dto.Book;
import com.codemach.jpa.service.BookDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookDataService bookDataService;

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        log.debug("Inside addBook, book: {}", book);
        book = bookDataService.create(book);
        log.debug("Leaving addBook, book: {}", book);
        return ResponseEntity.ok(book);
    }

    @ResponseBody
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @RequestParam Integer id) {
        log.debug("Inside updateBook, book: {}", book);
        book = bookDataService.update(id, book);
        log.debug("Leaving addBook, book: {}", book);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<List<Book>> findAll() {
        log.debug("Inside findAll");
        List<Book> bookList = bookDataService.getAll();
        log.debug("Leaving findAll, bookList: {}", bookList);
        return ResponseEntity.ok(bookList);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        log.debug("Inside delete");
        bookDataService.delete(id);
        log.debug("Leaving delete");
        return ResponseEntity.ok("deleted book with id: " + id);
    }
}