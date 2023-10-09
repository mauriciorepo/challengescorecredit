package com.challenge.creditscore.application.ports.in;

import com.challenge.creditscore.application.core.domain.ScoreCredit;

public interface CreateScoreCreditInputPort {

    public void create(ScoreCredit scoreCredit);
}
