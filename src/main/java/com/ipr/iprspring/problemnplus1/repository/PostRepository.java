package com.ipr.iprspring.problemnplus1.repository;

import com.ipr.iprspring.common.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}