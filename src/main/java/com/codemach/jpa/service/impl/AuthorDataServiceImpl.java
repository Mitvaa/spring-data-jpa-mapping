package com.codemach.jpa.service.impl;

import com.codemach.jpa.dto.Author;
import com.codemach.jpa.entity.AuthorData;
import com.codemach.jpa.repository.AuthorDataRepository;
import com.codemach.jpa.service.AuthorDataService;
import com.codemach.jpa.transformer.AuthorTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorDataServiceImpl implements AuthorDataService {

    private final AuthorDataRepository authorDataRepository;
    private final AuthorTransformer authorTransformer;

    @Override
    public Author create(Author author) {
        AuthorData authorData = authorTransformer.toEntity(author);
        authorData = authorDataRepository.save(authorData);
        author = authorTransformer.fromEntity(authorData);
        return author;
    }

    @Override
    public Author update(Integer id, Author author) {
        author.setId(id);
        AuthorData authorData = authorTransformer.toEntity(author);
        authorData = authorDataRepository.save(authorData);
        author = authorTransformer.fromEntity(authorData);
        return author;
    }

    @Override
    public List<Author> getAll() {
        List<AuthorData> authorDataList = authorDataRepository.findAll();
        return authorDataList
            .stream()
            .map(authorTransformer::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        authorDataRepository.deleteById(id);
    }
}