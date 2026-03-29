package it.andrea.pokemon.model.condition;

import it.andrea.pokemon.model.number.INumber;

public class LessThanOrEqual implements ICondition<INumber> {

    private INumber number;

    @Override
    public boolean check(INumber iNumber) {
        return false;
    }
}
