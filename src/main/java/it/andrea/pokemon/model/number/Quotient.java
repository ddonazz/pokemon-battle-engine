package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

public class Quotient implements INumber {

    private final INumber dividend;
    private final INumber divisor;

    public Quotient(INumber dividend, INumber divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    
    @Override
    public double evaluate(Battle battle) {
        return dividend.evaluate(battle) / divisor.evaluate(battle);
    }
}
