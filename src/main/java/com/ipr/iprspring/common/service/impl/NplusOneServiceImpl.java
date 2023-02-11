package com.ipr.iprspring.common.service.impl;

import com.ipr.iprspring.common.exception.NotFoundException;
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
        //при это произойдет запрос с join, хотя мы не запрашивали данные родительского поста
        //Hibernate: select p1_0.id,p2_0.id,p2_0.title,p1_0.review from post_comment p1_0
        // join post p2_0 on p2_0.id=p1_0.post_id where p1_0.id=?
        var postComment = postCommentRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //представим что нам нужно получить текст комментария
        var commentText = postComment.getReview();
        log.info(commentText);
    }

    /**
     * Hibernate: select p1_0.id,p1_0.post_id,p1_0.review from post_comment p1_0 where p1_0.id=?
     *
     * @param commentId id комментария
     */
    @Override
    public void testNplOneResolve(UUID commentId) {
        //тут entity с lazy(ленивой подгрузкой), будет запрашивать данные только если мы вызвали их
        //при это произойдет запрос без join
        //Hibernate: select p1_0.id,p1_0.post_id,p1_0.review from post_comment p1_0 where p1_0.id=?
        var postComment = postCommentFixNplusOneRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //представим что нам нужно получить текст комментария
        var commentText = postComment.getReview();

        //если мы отдельно запросим название поста, то хибернейт запросит так дополнительно
        //Hibernate: select p1_0.id,p1_0.title from post p1_0 where p1_0.id=?
        //var title = postComment.getPost().getTitle();
        log.info(commentText);
    }

}
