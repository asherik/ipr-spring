package com.ipr.iprspring.common.controller;

import com.ipr.iprspring.common.enums.CommentType;
import com.ipr.iprspring.common.service.CommonService;
import com.ipr.iprspring.common.service.NplusOneService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class IprController {

    private final NplusOneService nplusOne;
    private final CommonService commonService;

    /**
     * Проблема n+1 воспроизведена.
     *
     * @param idComment id комментария
     * @return {@link ResponseEntity}
     */
    @GetMapping("/nplusone")
    public ResponseEntity<Void> getNplusOne(@RequestParam @Valid @NonNull UUID idComment) {
        nplusOne.testNplOne(idComment);
        return ResponseEntity.ok().build();
    }

    /**
     * Проблема n+1 устранена (с измененными entity).
     *
     * @param idComment id комментария
     * @return {@link ResponseEntity}
     */
    @GetMapping("/nplusone-resolve")
    public ResponseEntity<Void> getNplusOneResolve(@RequestParam @Valid @NonNull UUID idComment) {
        nplusOne.testNplOneResolve(idComment);
        return ResponseEntity.ok().build();
    }


    /**
     * Сохранение енам в виде числа.
     *
     * @param idComment   id комментария
     * @param commentType тип комменатрия в виде enum
     * @return {@link ResponseEntity}
     */
    @PutMapping("/update-comment")
    public ResponseEntity<Void> getNplusOneResolve(@RequestParam @Valid @NonNull UUID idComment,
                                                   @RequestParam @Valid @NonNull CommentType commentType) {
        commonService.saveEnumFieldInDb(idComment, commentType);
        return ResponseEntity.ok().build();
    }
}
