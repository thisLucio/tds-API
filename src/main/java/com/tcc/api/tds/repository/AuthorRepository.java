package com.tcc.api.tds.repository;

import com.tcc.api.tds.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
