package com.challenge.creditscore.application.ports.out;

import com.challenge.creditscore.application.core.domain.ScoreCredit;

public interface SendScoreCreditMessageOutputPort {

    public void send(ScoreCredit scoreCredit);
}
