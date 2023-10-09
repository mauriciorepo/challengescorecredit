package com.challenge.creditscore.application.core.usecase;

import com.challenge.creditscore.application.core.domain.ScoreCredit;
import com.challenge.creditscore.application.core.domain.User;
import com.challenge.creditscore.application.ports.in.CalculateScoreCreditInputPort;

import java.util.Random;

public class CalculateScoreCreditUseCase implements CalculateScoreCreditInputPort {


    @Override
    public String calculate(User user, ScoreCredit scoreCredit) {


        Random random = new Random();

        // Gere um número aleatório no intervalo de 300 a 800 (inclusive)
        int numeroAleatorio = random.nextInt(501) + 300;
        return String.valueOf(numeroAleatorio);
    }
}
