package com.challenge.creditscore.adapters.in.controller;

import com.challenge.creditscore.adapters.in.controller.mapper.ScoreCreditRequestMapper;
import com.challenge.creditscore.adapters.in.controller.request.ScoreCreditRequest;
import com.challenge.creditscore.adapters.out.repository.entity.ScoreCreditEntity;
import com.challenge.creditscore.application.ports.in.CreateScoreCreditInputPort;
import com.challenge.creditscore.application.ports.in.GenerateScoreCreditInputPort;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/scores")
@Slf4j
public class ScoreCreditController {
    @Autowired
    private GenerateScoreCreditInputPort generateScoreCreditInputPort;
    @Autowired
    private ScoreCreditRequestMapper scoreCreditRequestMapper;

    @Autowired
    private CreateScoreCreditInputPort createScoreCreditInputPort;


    @GetMapping
    public ResponseEntity<String> getScore(@PathParam("cpf") String cpf){
        log.info("Inserindo dados de score");
        var scoreCredit = generateScoreCreditInputPort.generate(cpf);
        return ResponseEntity.ok(scoreCredit);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ScoreCreditRequest scoreCreditRequest){
        log.info("Avaliando score do cliente!!");
        var scoreCredit = scoreCreditRequestMapper.toScoreCredit(scoreCreditRequest);
        createScoreCreditInputPort.create(scoreCredit);
        return  ResponseEntity.ok().build();
    }
}
