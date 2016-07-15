package com.developforfun.armybuilder.models;

public class ConfigurationException extends RuntimeException {
    public ConfigurationException() {
        super("Configuration Issues");
    }

    public ConfigurationException(String msg) {
        super(msg);
    }
}
