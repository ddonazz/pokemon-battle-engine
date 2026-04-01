package it.andrea.pokemon.model.rules;

import it.andrea.pokemon.battle.Battle;

public interface IDamageFormula {

    /**
     * Calcola il danno finale in base alle regole della generazione.
     *
     * @param battle    Il contesto della battaglia (per recuperare attaccante e difensore)
     * @param basePower La potenza base della mossa usata
     * @return Il danno calcolato da infliggere
     */
    int calculate(Battle battle, double basePower);

}
