package it.andrea.pokemon.battle;

import it.andrea.pokemon.utils.PokemonType;

import java.util.Map;
import java.util.Set;

public class Battler {

    private String name;
    private Set<PokemonType> types;
    private StatusCondition statusCondition;
    private int statusTurns;
    private PokemonStats stats;
    private int currentHp;
    private Map<StatType, Integer> statStaged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(Set<PokemonType> types) {
        this.types = types;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public Map<StatType, Integer> getStatStaged() {
        return statStaged;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = Math.max(0, Math.min(currentHp, stats.getMaxHp()));
    }

    public void setStatusCondition(StatusCondition statusCondition) {
        if (this.statusCondition == StatusCondition.NONE || statusCondition == StatusCondition.NONE) {
            this.statusCondition = statusCondition;
            this.statusTurns = 0;
        }
    }

    public StatusCondition getStatusCondition() {
        return statusCondition;
    }

    public int getStat(StatType statType) {
        return switch (statType) {
            case HP -> getStats().getMaxHp();
            case ATTACK -> getStats().getAttack();
            case DEFENSE -> getStats().getDefense();
            case SPECIAL_ATTACK -> getStats().getSpecialAttack();
            case SPECIAL_DEFENSE -> getStats().getSpecialDefense();
            case SPEED -> getStats().getSpeed();
            default -> throw new IllegalArgumentException("Stat not supported: " + statType);
        };
    }
}
