package com.tcc.api.tds.repository;

import com.tcc.api.tds.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
