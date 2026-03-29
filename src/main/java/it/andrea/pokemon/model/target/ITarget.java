package it.andrea.pokemon.model.target;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;

public interface ITarget {

    Battler resolve(Battle battle);
}
