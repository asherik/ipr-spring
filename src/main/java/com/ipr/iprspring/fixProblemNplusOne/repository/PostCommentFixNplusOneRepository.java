package com.ipr.iprspring.fixProblemNplusOne.repository;

import com.ipr.iprspring.fixProblemNplusOne.domain.PostCommentFixNplusOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostCommentFixNplusOneRepository extends JpaRepository<PostCommentFixNplusOne, UUID> {
}