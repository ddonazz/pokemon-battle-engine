package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;

public class Drain implements IEffect {

    private final ITarget attacker;
    private final ITarget defender;
    private final INumber damage;
    private final INumber drainFraction;

    public Drain(ITarget attacker, ITarget defender, INumber damage, INumber drainFraction) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.drainFraction = drainFraction;
    }

    @Override
    public void apply(Battle battle) {
        Battler source = attacker.resolve(battle);
        Battler target = defender.resolve(battle);

        int calculatedDamage = (int) damage.evaluate(battle);

        int actualDamage = Math.min(calculatedDamage, target.getCurrentHp());

        target.takeDamage(actualDamage);

        if (actualDamage > 0) {
            int healAmount = (int) Math.max(1, Math.floor(actualDamage * drainFraction.evaluate(battle)));
            source.heal(healAmount);
        }
    }
}
