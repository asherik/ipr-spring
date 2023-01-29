package com.ipr.iprspring.common.controller;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ipr.iprspring.problemnplus1.repository.NplusOne;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class IprController {

    private final NplusOne nplusOne;

    @GetMapping("/nplusone")
    public ResponseEntity<Void> getNplusOne(@RequestParam @Valid @NonNull UUID idComment) {
        nplusOne.testNplOne(idComment);
        return ResponseEntity.ok().build();
    }

}
