package com.ipr.iprspring.common.service.impl;

import com.ipr.iprspring.common.service.IsolateService;
import com.ipr.iprspring.fixProblemNplusOne.repository.PostCommentFixNplusOneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class IsolateServiceImpl implements IsolateService {

    private final PostCommentFixNplusOneRepository postCommentFixNplusOneRepository;

    //уровень изоляции READ_COMMITTED и так по дефолту, указал для наглядности
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void changeViewForCommentReadCommitted(UUID commentId) {
        updateView(commentId);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void changeViewForCommentRepeatableRead(UUID commentId) {
        updateView(commentId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void changeViewForCommentReadUncommitted(UUID commentId) {
        updateView(commentId);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void changeViewForCommentSerializable(UUID commentId) {
        updateView(commentId);
    }

    /**
     * Обновление счетчика просмотров комментария.
     *
     * @param commentId id комментария
     */
    private void updateView(UUID commentId) {
        postCommentFixNplusOneRepository.updateCount(commentId);
        var count = postCommentFixNplusOneRepository.getCount(commentId);
        log.info("текущее кол-во просмотров: {}", count);
    }
}
