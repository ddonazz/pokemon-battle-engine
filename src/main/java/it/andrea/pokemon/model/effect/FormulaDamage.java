package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;

public class FormulaDamage implements IEffect {

    private final INumber number;

    public FormulaDamage(INumber number) {
        this.number = number;
    }
    
    @Override
    public void apply(Battle battle) {

    }
}
