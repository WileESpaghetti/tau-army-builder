package com.developforfun.armybuilder.models.infantry;

import com.developforfun.armybuilder.items.Armory;
import com.developforfun.armybuilder.models.Model;

/* FIXME:
 * The Warhammer 40,000 rulebook lists infantry under the "Unit Types".
 * In the rulebook, a "unit" refers to a group of "Models". For the sake of the
 * program, I think it makes sense to apply the information partaining to the
 * "Unit Type" to the individual model. Need to find out if this will make a
 * difference when creating the class for Units.
 */
public class Infantry extends Model {
    public Infantry(String name, int cost, InfantryProfile characteristics, Armory defaults, Armory options) {
        super(name, cost, characteristics, defaults, options);
    }
}