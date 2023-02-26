package com.ipr.iprspring.common.service;

import java.util.UUID;

public interface IsolateService {

    /**
     * Увеличение счетчика просмотров, изоляция READ_COMMITTED.
     *
     * @param commentId id комментария
     */
    void changeViewForCommentReadCommitted(UUID commentId);

    /**
     * Увеличение счетчика просмотров, изоляция REPEATABLE_READ.
     *
     * @param commentId id комментария
     */
    void changeViewForCommentRepeatableRead(UUID commentId);

    /**
     * Увеличение счетчика просмотров, изоляция READ_UNCOMMITTED.
     *
     * @param commentId id комментария
     */
    void changeViewForCommentReadUncommitted(UUID commentId);

    /**
     * Увеличение счетчика просмотров, изоляция SERIALIZABLE.
     *
     * @param commentId id комментария
     */
    void changeViewForCommentSerializable(UUID commentId);
}

