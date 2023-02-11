package com.ipr.iprspring.common.service;

import java.util.UUID;

public interface NplusOneService {

    /**
     * Воспроизведение проблемы n+1
     *
     * @param commentId id комментария
     */
    void testNplOne(UUID commentId);


    /**
     * Решение проблемы n+1 (с измененными entity)
     *
     * @param commentId id комментария
     */
    void testNplOneResolve(UUID commentId);

}
