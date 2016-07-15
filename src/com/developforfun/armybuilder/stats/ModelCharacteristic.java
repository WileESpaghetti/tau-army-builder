package com.developforfun.armybuilder.stats;

public abstract class ModelCharacteristic {
    private String name;
    private int value;

    public ModelCharacteristic(String statName, int val) {
        name = statName;
        value = val;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%d", getValue());
    }

    protected abstract boolean isValid();
}
