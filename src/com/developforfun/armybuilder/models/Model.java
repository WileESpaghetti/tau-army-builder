package com.developforfun.armybuilder.models;

import com.developforfun.armybuilder.items.Armory;
import com.developforfun.armybuilder.items.Equipment;
import com.developforfun.armybuilder.stats.Profile;

/* FIXME:
 * Stuff in here also applies to Weapons, but Weapons are kind of an awkward fit
 * as a Model since they are subclasses of Equipment, and Equipment may or may not
 * have a Profile associated with them.
 */
/* FIXME:
 * squads will have an iterator that loops through each member in the squad.
 * Does it make sense to have an iterator for Model that loops through the equipment?
 */
/**
 * Represents a single model on the battlefield
 */
public class Model implements Cloneable {
    private final String NAME;
    private final int BASE_COST;
    private final Profile BASE_PROFILE;

    private Armory BASE_EQUIPMENT;
    private Armory EQUIPMENT_OPTIONS;
    private Armory equipped;

    /**
     * @return name of the model
     */
    public String getName() {
        return NAME;
    }

    /**
     * @return cost of the model without any modifiers
     */
    public int getBaseCost() {
        return BASE_COST;
    }

    /**
     * Prefer this over getBaseCost() unless you explicitly need the unmodified cost
     *
     * @return base cost + any modifiers.
     */
    public int getCost() {
        return getBaseCost();
    }

    /* FIXME:
     * not sure if this really needs to be public. I can't see a use case where you
     * would need to view a Model's defaults unless you were trying to do something
     * similar to resetEquipment();
     *
     * This might be a good candidate for deprecation/removal down the road
     */
    /**
     * @return list of characteristics and their values
     */
    public Profile getBaseProfile() {
        return BASE_PROFILE;
    }

    /**
     * Prefer this over getBaseProfile() unless you explicitly need the unmodified
     * characteristics.
     *
     * @return base characteristics + any modifiers.
     */
    public Profile getProfile() {
        return getBaseProfile();
    }

    /**
     * Removes any equipped items and resets the model to have it's default
     * equipment
     */
    public void resetEquipment() {
        equipped = new Armory();

        for (Equipment e: getBaseEquipment()) {
            getEquipment().add(e);
        }
    }

    public Armory getBaseEquipment() {
        return BASE_EQUIPMENT.clone();
    }

    public Armory getEquipmentOptions() {
        return EQUIPMENT_OPTIONS.clone();
    }

    public Armory getEquipment() {
        return equipped.clone();
    }

    public Model(String name, int cost, Profile characteristics, Armory defaults, Armory options) {
        NAME = name;
        BASE_COST = cost;
        BASE_PROFILE = characteristics;

        if (defaults == null || characteristics == null || options == null) {
            /* FIXME:
             * disabling this check for now. Until armories are better implemented
             */
            //throw new ConfigurationException("No default equipment given");
        } else {
            BASE_EQUIPMENT = defaults;
            EQUIPMENT_OPTIONS = options;
            resetEquipment();
        }
    }

    /**
     * Creates a new Model using the same defaults as the current one, then it
     * adds any needed equipment
     *
     * @return a new Model configured the same as the current one
     * @throws CloneNotSupportedException
     */
    @Override
    protected Model clone() throws CloneNotSupportedException {
        Model copy = new Model(getName(), getBaseCost(), getBaseProfile(), getBaseEquipment(), getEquipmentOptions());

        /* FIXME:
         * this bypasses the normal equipping process. Is this good/desired?
         */
        for(Equipment e: getEquipment()) {
            copy.getEquipment().add(e);
        }

        return copy;
    }
}
