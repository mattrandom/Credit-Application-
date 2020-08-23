package mattrandom.creditapp.core;

import mattrandom.creditapp.core.exception.RequirementNotMetCause;
import mattrandom.creditapp.core.model.PersonalData;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

public class CreditApplicationDecision implements Serializable {
    public static final long serialVersionUID = 1L;

    private final DecisionType type;
    private final transient Optional<RequirementNotMetCause> requirementNotMetCause;
    private final PersonalData personalData;
    private final Double creditRate;
    private final Integer scoring;

    public CreditApplicationDecision(DecisionType type, PersonalData personalData, Double creditRate, Integer scoring) {
        this.type = type;
        this.personalData = personalData;
        this.creditRate = creditRate;
        this.scoring = scoring;
        this.requirementNotMetCause = Optional.empty();
    }

    public CreditApplicationDecision(DecisionType type, PersonalData personalData, Double creditRate, Integer scoring, RequirementNotMetCause cause) {
        this.type = type;
        this.personalData = personalData;
        this.creditRate = creditRate;
        this.scoring = scoring;
        this.requirementNotMetCause = Optional.of(cause);
    }

    public Optional<RequirementNotMetCause> getRequirementNotMetCause() {
        return requirementNotMetCause;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Double getCreditRate() {
        return creditRate;
    }

    public int getScoring() {
        return scoring;
    }

    public DecisionType getType() {
        return type;
    }
}
