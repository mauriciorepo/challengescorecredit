package com.challenge.creditscore.application.core.usecase;

import com.challenge.creditscore.application.core.domain.ScoreCredit;
import com.challenge.creditscore.application.ports.in.CreateScoreCreditInputPort;
import com.challenge.creditscore.application.ports.out.CreateScoreCreditOutputPort;
import com.challenge.creditscore.application.ports.out.SendScoreCreditMessageOutputPort;

public class CreateScoreCreditUseCase implements CreateScoreCreditInputPort {

    private final CreateScoreCreditOutputPort createScoreCreditOutputPort;
    private final SendScoreCreditMessageOutputPort sendScoreCreditMessageOutputPort;
    public CreateScoreCreditUseCase(CreateScoreCreditOutputPort createScoreCreditOutputPort, SendScoreCreditMessageOutputPort sendScoreCreditMessageOutputPort) {
        this.createScoreCreditOutputPort = createScoreCreditOutputPort;
        this.sendScoreCreditMessageOutputPort = sendScoreCreditMessageOutputPort;
    }

    @Override
    public void create(ScoreCredit scoreCredit) {
        createScoreCreditOutputPort.create(scoreCredit);
        sendScoreCreditMessageOutputPort.send(scoreCredit);

    }
}
