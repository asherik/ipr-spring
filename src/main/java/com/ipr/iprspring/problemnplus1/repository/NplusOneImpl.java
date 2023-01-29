package com.ipr.iprspring.problemnplus1.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class NplusOneImpl implements NplusOne {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    public void testNplOne(UUID commentId) {
        postCommentRepository.findById(commentId);
    }

}
