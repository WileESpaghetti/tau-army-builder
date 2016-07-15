package com.developforfun.armybuilder.stats;

import java.util.Arrays;
import java.util.Iterator;

public class Profile implements Iterable<ModelCharacteristic> {
    protected ModelCharacteristic[] characteristics;

    public ModelCharacteristic[] getCharacteristics() {
        return characteristics;
    }

    @Override
    public Iterator<ModelCharacteristic> iterator() {
        return Arrays.asList(characteristics).iterator();
    }

    @Override
    public String toString() {
        StringBuilder profile = new StringBuilder();
        for(ModelCharacteristic mc: this) {
            profile.append("\t");
            profile.append(mc);
        }
        return profile.toString().trim();
    }

    public String getHeader() {
        StringBuilder profileHeader = new StringBuilder();
        for (ModelCharacteristic mc: this) {
            profileHeader.append("\t");
            profileHeader.append(mc.getName());
        }
        return profileHeader.toString().trim();
    }

    public String getHeader(int indent) {
        return String.format("%"+indent+"s\t%s", "", getHeader());
    }
}
