package com.github.kazuhito_m.gdcrconwaysgameoflife.presentation.controller;

import com.github.kazuhito_m.gdcrconwaysgameoflife.application.LifeGameService;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldCondition;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/gameOfLife")
class LifeGameController {
    private final LifeGameService service;

    @PostMapping(value = "initialize", produces = "application/json; charset=UTF-8")
    void initialize(@RequestBody WorldCondition condition, HttpSession session) {
        service.initialize(session.getId(), condition);
    }

    @GetMapping("getMatrix")
    int[][] getMatrix(HttpSession session) {
        return service.nextWorldOf(session.getId()).matrix();
    }

    LifeGameController(LifeGameService service) {
        this.service = service;
    }
}
