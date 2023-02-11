package com.ipr.iprspring.common.service.impl;

import com.ipr.iprspring.common.enums.CommentType;
import com.ipr.iprspring.common.exception.NotFoundException;
import com.ipr.iprspring.common.service.CommonService;
import com.ipr.iprspring.fixProblemNplusOne.repository.PostCommentFixNplusOneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
}
