package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;

/**
 * An effect is an action that can be applied to a battle, such as damage, healing, status changes, etc.
 * <p>
 * Effects can be applied to the attacker, the defender, or both. They can be:
 * <ul>
 * <li>Sequential (damage then status)</li>
 * <li>Conditional (based on target state)</li>
 * </ul>
 * </p>
 */
public interface IEffect {

    void apply(Battle battle);

}
