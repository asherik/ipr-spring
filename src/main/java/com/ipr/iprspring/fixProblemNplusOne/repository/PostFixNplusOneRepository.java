package com.ipr.iprspring.fixProblemNplusOne.repository;

import com.ipr.iprspring.fixProblemNplusOne.domain.PostFixNplusOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostFixNplusOneRepository extends JpaRepository<PostFixNplusOne, UUID> {
}