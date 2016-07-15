package com.developforfun.armybuilder.items;

import java.util.ArrayList;
import java.util.Iterator;

/* Armories need to have stuff like conflicts, dependancies, and limits (ex. only one sgt upgrade)*/

public class Armory implements Cloneable, Iterable<Equipment> {
    private ArrayList<Equipment> allowedItems = new ArrayList<Equipment>();
    private String name;

    /* FIXME this works for models.equipment armories, but does not work for things
     * like HQ armories that are expected to have all items regardless of dependencies
     * or item conflicts. It might be better to have the armory ask for the Equipment's
     * dependencies/conflicts and take them into account during the Armory.canAdd()
     * calculation
     */
    public boolean canAdd(Equipment a) {
        // should default to allowing items to be added
        boolean hasConflicts = false;
        boolean hasRequired = true;

        // check for item conflicts
        if (a.getConflicts() != null) {
            for(Equipment conflictingItem: a.getConflicts()) {
                if (contains(conflictingItem)) {
                    hasConflicts = true;
                    break;
                }
            }
        }

        //don't waste time checking for Equipment dependancies if we already have conflicts
        if(!hasConflicts && a.getDependancies() != null) {
            for(Equipment requiredItem: a.getDependancies()) {
                if (! contains(requiredItem)) {
                    // we have found a missing requirement
                    hasRequired = false;
                    break;
                }
            }
        }

        return hasRequired && (!hasConflicts);
    }

    public void add(Equipment e) {
        if(canAdd(e)){
            allowedItems.add(e);
        }
    }

    // FIXME this seems like a hack to have this here, shouldn't a unit be in charge of calculating it's own cost
    // The only use case where this makes sense is calculating a unit's total cost
    public int getTotalCost() {
        int cost = 0;
        for(Equipment e: allowedItems) {
            cost += e.getCost();
        }
        return cost;
    }

    public boolean contains(Equipment e) {
        boolean doesContain = false;
        for (Equipment allowed: allowedItems) {
            // FIXME: this should use e.equals(allowed) instead
            if (e.getName().equals(allowed.getName())) {
                doesContain = true;
                break;
            }
        }

        return doesContain;
    }

    @Override
    public Armory clone() {
        Armory a = new Armory();

        for (Equipment e: allowedItems) {
            a.add(e);

        }
        return a;
    }

    @Override
    public String toString() {
        StringBuilder itemList = new StringBuilder();
        for(Equipment e: allowedItems) {
            itemList.append("\t");
            itemList.append(e);
            itemList.append("\n\t");
        }


        return itemList.toString();
    }

    @Override
    public Iterator<Equipment> iterator() {
        return allowedItems.iterator();
    }
}