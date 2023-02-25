package com.ipr.iprspring.common.controller;

import com.ipr.iprspring.common.service.IsolateService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class IprIsolationController {

    private final IsolateService isolateService;

    /**
     * Увеличение счетчика просмотров.
     *
     * @param idComment id комментария
     * @return {@link ResponseEntity}
     */
    @PutMapping("/change-comment-view")
    public ResponseEntity<Void> changeViewForComment(@RequestParam @Valid @NonNull UUID idComment,
                                                     @RequestParam @Valid @NonNull String isolation) {
        if (isolation.equals(Isolation.READ_COMMITTED.name())) {
            isolateService.changeViewForCommentReadCommitted(idComment);
        } else if (isolation.equals(Isolation.REPEATABLE_READ.name())) {
            isolateService.changeViewForCommentRepeatableRead(idComment);
        }
        return ResponseEntity.ok().build();
    }
}
