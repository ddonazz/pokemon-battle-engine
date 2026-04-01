package it.andrea.pokemon.battle;

import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;
import it.andrea.pokemon.utils.StatusCondition;

import java.util.List;
import java.util.Map;

public class Battler {

    private String name;
    private List<PokemonType> types;
    private int level;
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

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = Math.clamp(currentHp, 0, stats.getMaxHp());
    }

    public int getLevel() {
        return level;
    }

    public Map<StatType, Integer> getStatStaged() {
        return statStaged;
    }

    public StatusCondition getStatusCondition() {
        return statusCondition;
    }

    public void setStatusCondition(StatusCondition statusCondition) {
        if (this.statusCondition == StatusCondition.NONE || statusCondition == StatusCondition.NONE) {
            this.statusCondition = statusCondition;
            this.statusTurns = 0;
        }
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

    public void takeDamage(int damage) {
        if (damage < 0) return;
        setCurrentHp(this.currentHp - damage);
    }

    public void heal(int amount) {
        if (amount < 0) return;
        setCurrentHp(this.currentHp + amount);
    }
}
