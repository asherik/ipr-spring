package com.ipr.iprspring.problemnplus1.repository;

import com.ipr.iprspring.problemnplus1.domain.PostCommentForNplusOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostCommentRepository extends JpaRepository<PostCommentForNplusOne, UUID> {
}