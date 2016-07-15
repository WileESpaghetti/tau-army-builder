package com.developforfun.armybuilder.stats;

import com.developforfun.armybuilder.models.ConfigurationException;

public class StatOutOfRangeException extends ConfigurationException {
    public StatOutOfRangeException(int min, int max) {
        super(String.format("ModelCharacteristic must be between %d and %d", min, max));
    }
}
