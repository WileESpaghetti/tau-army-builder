package com.developforfun.armybuilder.models.infantry;

import com.developforfun.armybuilder.stats.FixedRangeCharacteristic;
import com.developforfun.armybuilder.stats.StatOutOfRangeException;

public class SaveCharacteristic extends FixedRangeCharacteristic {

    public SaveCharacteristic(int val) throws StatOutOfRangeException {
        super("Sv", val, 0, 6);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (getValue() < 2) {
            str.append("-");
        } else {
            str.append(getValue());
            str.append("+");
        }

        return str.toString();
    }
}
