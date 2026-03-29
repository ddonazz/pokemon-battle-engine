package it.andrea.pokemon.model.target;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;

public class Defender implements ITarget {

    @Override
    public Battler resolve(Battle battle) {
        return battle.getDefender();
    }
}
