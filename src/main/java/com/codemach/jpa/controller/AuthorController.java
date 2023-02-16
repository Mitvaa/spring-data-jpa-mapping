package com.codemach.jpa.controller;

import com.codemach.jpa.dto.Author;
import com.codemach.jpa.service.AuthorDataService;
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
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDataService authorDataService;

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        log.debug("Inside addAuthor, author: {}", author);
        author = authorDataService.create(author);
        log.debug("Leaving addAuthor, author: {}", author);
        return ResponseEntity.ok(author);
    }

    @ResponseBody
    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @RequestParam Integer id) {
        log.debug("Inside updateAuthor, author: {}", author);
        author = authorDataService.update(id, author);
        log.debug("Leaving addAuthor, author: {}", author);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<List<Author>> findAll() {
        log.debug("Inside findAll");
        List<Author> authorList = authorDataService.getAll();
        log.debug("Leaving findAll, authorList: {}", authorList);
        return ResponseEntity.ok(authorList);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        log.debug("Inside delete");
        authorDataService.delete(id);
        log.debug("Leaving delete");
        return ResponseEntity.ok("deleted author with id: " + id);
    }
}
