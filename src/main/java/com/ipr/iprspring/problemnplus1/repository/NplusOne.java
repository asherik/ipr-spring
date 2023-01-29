package com.ipr.iprspring.problemnplus1.repository;

import java.util.UUID;

public interface NplusOne {

    /**
     * Тестирование сценария когда происходит много запросов к бд.
     *
     * @param commentId id комментария
     */
    void testNplOne(UUID commentId);
}
