package com.developforfun.armybuilder;

import com.developforfun.armybuilder.items.Armory;
import com.developforfun.armybuilder.items.Equipment;
import com.developforfun.armybuilder.items.weapons.WeaponProfile;
import com.developforfun.armybuilder.models.infantry.InfantryProfile;
import com.developforfun.armybuilder.models.vehicles.VehicleProfile;
import com.developforfun.armybuilder.stats.Profile;
import com.developforfun.armybuilder.stats.ProfileReader;

public class Main {
    /* FIXME:
     * Weapons do not have a way to represent a range using templates
     *      ex. flamer or stuff using blast markers, or unlimited
     *
     * Weapons do not currently include a way to hold the number of hits
     *      ex. type "Assault 3" is actually type "Assault" with 3 hits
     *
     * Equipment does not currently have a way to store notes
     *      ex. "Ignores Cover"
     */

    public static void main(String[] args) {
        InfantryProfile fireWarriorProfile = new InfantryProfile(2, 3, 3, 3, 1, 2, 1, 7, 4);

        System.out.println(fireWarriorProfile.getHeader(21));
        ProfileReader.getInfantryProfiles(args[0]);
        System.out.println();

        System.out.println(new VehicleProfile(0,0,0,0,0).getHeader(25));
        ProfileReader.getVehicleProfiles(args[1]);
        System.out.println();

        System.out.println(new WeaponProfile(0,0,0).getHeader(32));
        ProfileReader.getWeaponProfiles(args[2]);
    }
}