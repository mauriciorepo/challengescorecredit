package com.challenge.creditscore.application.core.usecase;

import com.challenge.creditscore.application.core.exception.ScoreCreditNotFoundException;
import com.challenge.creditscore.application.ports.in.CalculateScoreCreditInputPort;
import com.challenge.creditscore.application.ports.in.GenerateScoreCreditInputPort;
import com.challenge.creditscore.application.ports.out.FindScoreCreditOutputPort;
import com.challenge.creditscore.application.ports.out.FindUserByCpfOutputPort;

public class GenerateScoreCreditUseCase implements GenerateScoreCreditInputPort {

    private final FindUserByCpfOutputPort findUserByCpfOutputPort;
    private final FindScoreCreditOutputPort findScoreCreditOutputPort;
    private final CalculateScoreCreditInputPort calculateScoreCreditInputPort;

    public GenerateScoreCreditUseCase(FindUserByCpfOutputPort findUserByCpfOutputPort, FindScoreCreditOutputPort findScoreCreditOutputPort, CalculateScoreCreditInputPort calculateScoreCreditInputPort) {
        this.findUserByCpfOutputPort = findUserByCpfOutputPort;
        this.findScoreCreditOutputPort = findScoreCreditOutputPort;
        this.calculateScoreCreditInputPort = calculateScoreCreditInputPort;
    }

    @Override
    public String generate(String cpf) {
        var user = findUserByCpfOutputPort.find(cpf);


        var scoreCredit = findScoreCreditOutputPort.find(cpf).orElseThrow(()-> new ScoreCreditNotFoundException("Score Credit by cpf:" +cpf+ " not found"));

        return calculateScoreCreditInputPort.calculate(user,scoreCredit);
    }
}
