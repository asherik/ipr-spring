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


    /**
     * Получение кеширвоаных данных spring.
     *
     * @param commentId id комментария
     */
    String takeCachedComment(UUID commentId);

    /**
     * Практика сброса кеширвонных данных.
     *
     * @param commentId id комментария
     */
    void evictCachedComment(UUID commentId);
}
