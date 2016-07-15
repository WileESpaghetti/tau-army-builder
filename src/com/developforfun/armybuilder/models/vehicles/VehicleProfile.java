package com.developforfun.armybuilder.models.vehicles;

import com.developforfun.armybuilder.stats.FixedRangeCharacteristic;
import com.developforfun.armybuilder.stats.ModelCharacteristic;
import com.developforfun.armybuilder.stats.Profile;

/* FIXME:
 * not sure if this will work for stuff like Dreadnoughts that have WS
 * Maybe there needs to be a WalkerProfile that adds that kind of stuff
 */
public class VehicleProfile extends Profile {
    public VehicleProfile(int bs, int f, int s, int r, int hp) {
        characteristics = new ModelCharacteristic[5];

        characteristics[0] = new FixedRangeCharacteristic("BS", bs);
        characteristics[1] = new ArmorValue("F", f);
        characteristics[2] = new ArmorValue("S", s);
        characteristics[3] = new ArmorValue("R", r);
        characteristics[4] = new FixedRangeCharacteristic("HP", hp); // FIXME not sure if this needs to be a separate class
    }

    public ModelCharacteristic getBallisticSkill() {
        return characteristics[0];
    }

    public ModelCharacteristic getFront() {
        return characteristics[1];
    }

    public ModelCharacteristic getSide() {
        return characteristics[2];
    }

    public ModelCharacteristic getRack() {
        return characteristics[3];
    }

    public ModelCharacteristic getHullPoints() {
        return characteristics[4];
    }
}
