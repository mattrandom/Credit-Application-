package mattrandom.creditapp.core;

import mattrandom.creditapp.core.model.CreditApplication;
import mattrandom.creditapp.core.model.PersonalData;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class CreditApplicationDecisionFactory {

    public String getDesisionString(CreditApplication creditApplication, CreditApplicationDecision decision) {
        
        PersonalData personalData = creditApplication.getPerson().getPersonalData();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("translations", creditApplication.getClientLocale());
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(creditApplication.getClientLocale());

        switch (decision.getType()) {
            case POSITIVE:
                return String.format(resourceBundle.getString("decision1"), personalData.getName(), personalData.getLastName());
            case NEGATIVE_SCORING:
                return String.format(resourceBundle.getString("decision2"), personalData.getName(), personalData.getLastName());
            case NEGATIVE_RATING:
                BigDecimal roundedCreditRate = new BigDecimal(decision.getCreditRate()).setScale(2);
                return String.format(resourceBundle.getString("decision3"), personalData.getName(), personalData.getLastName(), numberFormat.format(roundedCreditRate.doubleValue()));
            case CONTACT_REQUIRED:
                return String.format(resourceBundle.getString("decision4"), personalData.getName(), personalData.getLastName());
            case NEGATIVE_REQUIREMENTS_NOT_MET:
                switch (decision.getRequirementNotMetCause().get()) {
                    case TOO_HIGH_PERSONAL_EXPENSES:
                        return String.format(resourceBundle.getString("decision5"), personalData.getName(), personalData.getLastName());
                    case TOO_LOW_LOAN_AMOUNT:
                        return String.format(resourceBundle.getString("decision6"), personalData.getName(), personalData.getLastName(), numberFormat.format(Constants.MIN_LOAN_AMOUNT_MORTGAGE));
                }
        }
        return null;
    }
}
