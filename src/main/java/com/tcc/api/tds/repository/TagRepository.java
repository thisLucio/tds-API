package com.tcc.api.tds.repository;

import com.tcc.api.tds.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
