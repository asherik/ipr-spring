package com.ipr.iprspring.common.service.impl;

import com.ipr.iprspring.common.service.NplusOneService;
import com.ipr.iprspring.fixProblemNplusOne.repository.PostCommentFixNplusOneRepository;
import com.ipr.iprspring.problemnplus1.repository.PostCommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class NplusOneServiceImpl implements NplusOneService {

    private final PostCommentRepository postCommentRepository;
    private final PostCommentFixNplusOneRepository postCommentFixNplusOneRepository;

    /**
     * Hibernate: select p1_0.id,p2_0.id,p2_0.title,p1_0.review from post_comment p1_0 join post p2_0 on p2_0.id=p1_0.post_id where p1_0.id=?
     *
     * @param commentId id комментария
     */
    @Override
    public void testNplOne(UUID commentId) {
        postCommentRepository.findById(commentId);
    }

    /**
     * Hibernate: select p1_0.id,p1_0.post_id,p1_0.review from post_comment p1_0 where p1_0.id=?
     *
     * @param commentId id комментария
     */
    @Override
    public void testNplOneResolve(UUID commentId) {
        postCommentFixNplusOneRepository.findById(commentId);
    }

}
