package com.developforfun.armybuilder.models.vehicles;

import com.developforfun.armybuilder.stats.FixedRangeCharacteristic;
import com.developforfun.armybuilder.stats.StatOutOfRangeException;

public class ArmorValue extends FixedRangeCharacteristic {
    public static final int MAX = 14; // I haven't seen anything in any Codex greater than this so far
    public static final int MIN = 10;

    public ArmorValue(String side, int val) throws StatOutOfRangeException {
        super(side, val, ArmorValue.MIN, ArmorValue.MAX);
    }
}
