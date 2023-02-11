package com.ipr.iprspring.common.controller;

import com.ipr.iprspring.common.service.NplusOneService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class IprController {

    private final NplusOneService nplusOne;

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

}
