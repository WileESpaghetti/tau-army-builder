package com.developforfun.armybuilder.items.weapons;

import com.developforfun.armybuilder.stats.FixedRangeCharacteristic;
import com.developforfun.armybuilder.stats.ModelCharacteristic;
import com.developforfun.armybuilder.stats.Profile;
import com.developforfun.armybuilder.stats.Range;

public class WeaponProfile extends Profile {
    public WeaponProfile(int range, int s, int ap) {
        characteristics = new ModelCharacteristic[3];

        characteristics[0] = new Range(range);
        characteristics[1] = new FixedRangeCharacteristic("S", s); // FIXME this does not handle kroot rifles which have a strength of "User" or stuff that has sniper value of "X"
        characteristics[2] = new FixedRangeCharacteristic("AP", ap);
    }

    public ModelCharacteristic getRange() {
        return characteristics[0];
    }

    public ModelCharacteristic getStrength() {
        return characteristics[1];
    }

    public ModelCharacteristic getArmorPiercing() {
        return characteristics[2];
    }
}
