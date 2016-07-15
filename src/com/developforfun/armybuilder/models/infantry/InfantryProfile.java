package com.developforfun.armybuilder.models.infantry;

import com.developforfun.armybuilder.stats.*;

public class InfantryProfile extends Profile {
    @Override
    public String toString() {
        StringBuilder profile = new StringBuilder();
        for (ModelCharacteristic attr: characteristics) {
            profile.append("\t");
            profile.append(attr);
        }

        return profile.toString().trim();
    }

    public InfantryProfile(int ws, int bs, int s, int t, int w, int i, int a, int ld, int sv) {
        characteristics = new FixedRangeCharacteristic[9];
        characteristics[0] = new FixedRangeCharacteristic("WS", ws);
        characteristics[1] = new FixedRangeCharacteristic("BS", bs);
        characteristics[2] = new FixedRangeCharacteristic("S", s);
        characteristics[3] = new FixedRangeCharacteristic("T", t);
        characteristics[4] = new FixedRangeCharacteristic("W", w);
        characteristics[5] = new FixedRangeCharacteristic("I", i);
        characteristics[6] = new FixedRangeCharacteristic("A", a);
        characteristics[7] = new FixedRangeCharacteristic("Ld", ld);
        characteristics[8] = new SaveCharacteristic(sv);
    }

    public ModelCharacteristic getWeaponSkill() {
        return characteristics[0];
    }

    public ModelCharacteristic getBallisticSkill() {
        return characteristics[1];
    }

    public ModelCharacteristic getStrength() {
        return characteristics[2];
    }

    public ModelCharacteristic getToughness() {
        return characteristics[3];
    }

    public ModelCharacteristic getWounds() {
        return characteristics[4];
    }

    private ModelCharacteristic getInitiative() {
        return characteristics[5];
    }

    public ModelCharacteristic getAttacks() {
        return characteristics[6];
    }

    public ModelCharacteristic getLeadership() {
        return characteristics[7];
    }

    public ModelCharacteristic getSave() {
        return characteristics[8];
    }

}