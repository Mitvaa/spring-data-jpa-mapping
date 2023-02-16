package com.codemach.jpa.transformer;

import com.codemach.jpa.dto.Author;
import com.codemach.jpa.entity.AuthorData;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorTransformer {

    public Author fromEntity(AuthorData authorData) {
        Author author = new Author();
        author.setId(authorData.getId());
        author.setName(authorData.getAuthorName());
        return author;
    }

    public AuthorData toEntity(Author author) {
        AuthorData authorData = new AuthorData();
        authorData.setId(author.getId());
        authorData.setAuthorName(author.getName());
        return authorData;
    }
}
