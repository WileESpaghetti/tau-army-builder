package com.developforfun.armybuilder.items;

import java.util.ArrayList;

/* FIXME may change the name of this class to Wargear */
public class Equipment {
    private final String NAME;
    private final int BASE_COST;
    private ArrayList<Equipment> conflicts;
    private ArrayList<Equipment> required;

    public Equipment(String name, int cost) {
        NAME = name;
        BASE_COST = cost;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d", getName(), getCost());
    }

    public String getName() {
        return NAME;
    }

    public int getBaseCost() {
        return BASE_COST;
    }

    public int getCost() {
        return getBaseCost();
    }

    /* FIXME this works for models.equipment armories, but does not work for things
     * like HQ armories that are expected to have all items regardless of dependencies
     * or item conflicts. It might be better to have the armory ask for the Equipment's
     * dependencies/conflicts and take them into account during the Armory.canAdd()
     * calculation
     */
    public boolean canAdd(Armory a) {
        // should default to allowing items to be added
        boolean hasConflicts = false;
        boolean hasRequired = true;

        // check for item conflicts
        if (conflicts != null) {
            for(Equipment conflictingItem: conflicts) {
                if (a.contains(conflictingItem)) {
                    hasConflicts = true;
                    break;
                }
            }
        }

        //don't waste time checking for Equipment dependancies if we already have conflicts
        if(!hasConflicts && required != null) {
            for(Equipment requiredItem: required) {
                if (! a.contains(requiredItem)) {
                    // we have found a missing requirement
                    hasRequired = false;
                    break;
                }
            }
        }

        return hasRequired && (!hasConflicts);
    }

    public ArrayList<Equipment> getConflicts() {
        return conflicts;
    }

    public ArrayList<Equipment> getDependancies() {
        return required;
    }
}
