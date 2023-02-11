package com.ipr.iprspring.common.service;

import com.ipr.iprspring.common.enums.CommentType;

import java.util.UUID;

public interface CommonService {

    /**
     * Сохранение числа просмотров комментария.
     *
     * @param commentId   id комментария
     * @param commentType тип комментария
     */
    void saveEnumFieldInDb(UUID commentId, CommentType commentType);

}
