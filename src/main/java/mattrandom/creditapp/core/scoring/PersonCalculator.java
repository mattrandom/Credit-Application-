package mattrandom.creditapp.core.scoring;

import mattrandom.creditapp.core.model.NaturalPerson;
import mattrandom.creditapp.core.model.Person;
import mattrandom.creditapp.core.model.SelfEmployed;

public interface PersonCalculator {

    default int calculate(Person person) {
        if (person instanceof SelfEmployed) {
            return calculate((SelfEmployed) person);
        } else if (person instanceof NaturalPerson) {
            return calculate((NaturalPerson) person);
        }
        return 0;
    }

    default int calculate(SelfEmployed selfEmployed) {
        return 0;
    }

    default int calculate(NaturalPerson naturalPerson) {
        return 0;
    }
}
