package com.ipr.iprspring.common.service.impl;

import com.ipr.iprspring.common.enums.CommentType;
import com.ipr.iprspring.common.exception.NotFoundException;
import com.ipr.iprspring.common.service.CommonService;
import com.ipr.iprspring.fixProblemNplusOne.repository.PostCommentFixNplusOneRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final PostCommentFixNplusOneRepository postCommentFixNplusOneRepository;

    @Override
    public void saveEnumFieldInDb(UUID commentId, CommentType commentType) {
        var postComment = postCommentFixNplusOneRepository.findById(commentId)
                .orElseThrow(NotFoundException::new);
        postComment.setCommentType(commentType);
        postCommentFixNplusOneRepository.save(postComment);
    }

    @Override
    @Cacheable(cacheNames = "commentsCache", key = "#commentId")
    @SneakyThrows
    public String takeCachedComment(UUID commentId) {
        TimeUnit.SECONDS.sleep(3L);
        var postComment = postCommentFixNplusOneRepository.findById(commentId)
                .orElseThrow(NotFoundException::new);
        return postComment.getReview();
    }

    @Override
    @CacheEvict("commentsCache")
    public void evictCachedComment(UUID commentId) {
    }
}

