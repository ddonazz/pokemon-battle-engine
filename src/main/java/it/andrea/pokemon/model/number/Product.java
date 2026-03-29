package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

public class Product implements INumber {

    private final INumber number1;
    private final INumber number2;

    public Product(INumber number1, INumber number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    
    @Override
    public double evaluate(Battle battle) {
        return number1.evaluate(battle) * number2.evaluate(battle);
    }
}
