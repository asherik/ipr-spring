package com.ipr.iprspring.fixProblemNplusOne.repository;

import com.ipr.iprspring.fixProblemNplusOne.domain.PostCommentFixNplusOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.UUID;

public interface PostCommentFixNplusOneRepository extends JpaRepository<PostCommentFixNplusOne, UUID> {

    @Query("select view from PostCommentFixNplusOne where id=:id")
    BigInteger getCount(UUID id);

    @Modifying
    @Query("update PostCommentFixNplusOne set view=view+1 where id=:id")
    void updateCount(UUID id);
}