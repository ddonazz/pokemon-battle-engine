package it.andrea.pokemon.model.move;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.model.condition.ICondition;

public interface IMove {

    void execute(Battle battle);

    default IMove withApplicability(ICondition<Battler> condition) {
        return new WithApplicability(condition, this);
    }

    default IMove withPrecondition(ICondition<Battle> battle) {
        return new  WithPrecondition(battle, this);
    }

}
