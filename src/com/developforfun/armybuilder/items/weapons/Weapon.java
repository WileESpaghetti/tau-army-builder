package com.developforfun.armybuilder.items.weapons;

import com.developforfun.armybuilder.items.Equipment;
import com.developforfun.armybuilder.stats.ModelCharacteristic;

public class Weapon extends Equipment {
    private final WeaponProfile BASE_STATS;
    private final String TYPE; // FIXME this should ideally be an enum

    public String getHeader() {
        return String.format("%s\tType", BASE_STATS.getHeader());
    }

    public ModelCharacteristic getRange() {
        return BASE_STATS.getRange();
    }

    public ModelCharacteristic getStrength() {
        return BASE_STATS.getStrength();
    }

    public ModelCharacteristic getArmorPiercing() {
        return BASE_STATS.getArmorPiercing();
    }

    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", getName(), BASE_STATS, getType());
    }

    public Weapon(String name, int cost, WeaponProfile baseStats, String type) {
        super(name, cost);
        BASE_STATS = baseStats;
        TYPE = type;
    }

}
