package com.codemach.jpa.repository;

import com.codemach.jpa.entity.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDataRepository extends JpaRepository<BookData, Integer> {
}
