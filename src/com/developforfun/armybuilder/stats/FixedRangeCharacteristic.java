package com.developforfun.armybuilder.stats;

/**
 * A charactistic that is bounded by a MIN and MAX value
 */
public class FixedRangeCharacteristic extends ModelCharacteristic{
    private static final int DEFAULT_MIN = 0; // most characteristics fall into this range
    private static final int DEFAULT_MAX = 10;
    public final int MIN;
    public final int MAX;

    public FixedRangeCharacteristic(String name, int value, int min, int max) {
        super(name, value);
        MIN = min;
        MAX = max;
    }
    public FixedRangeCharacteristic(String name, int value) {
        super(name, value);
        MIN = FixedRangeCharacteristic.DEFAULT_MIN;
        MAX = FixedRangeCharacteristic.DEFAULT_MAX;
    }

    @Override
    protected boolean isValid() {
        boolean isOK = true;
        // stuff < MIN will be ignored
        if (getValue() > MAX) {
            isOK = false;
        }
        return isOK;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (getValue() == 0) {
            str.append("-");
        } else {
            str.append(getValue());
        }

        return str.toString();
    }
}
