package com.challenge.creditscore.application.ports.in;

import com.challenge.creditscore.application.core.domain.ScoreCredit;
import com.challenge.creditscore.application.core.domain.User;

public interface CalculateScoreCreditInputPort {

    public String calculate(User user, ScoreCredit scoreCredit);
}
