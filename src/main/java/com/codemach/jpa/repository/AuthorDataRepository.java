package com.codemach.jpa.repository;

import com.codemach.jpa.entity.AuthorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDataRepository extends JpaRepository<AuthorData,Integer> {
}
