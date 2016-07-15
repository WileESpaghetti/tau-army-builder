package com.developforfun.armybuilder.stats;

import com.developforfun.armybuilder.items.weapons.WeaponProfile;
import com.developforfun.armybuilder.models.infantry.InfantryProfile;
import com.developforfun.armybuilder.models.vehicles.VehicleProfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads Profiles from a text file so that I don't accidentally include actual
 * Codex values during development. This helps respect Copyright's and lets you
 * add custom values if you want :)
 */
public class ProfileReader {
    public static ArrayList<Profile> getInfantryProfiles(String fileName) {
       ArrayList<Profile> profiles = new ArrayList<Profile>();
        try {
            Scanner ipr = new Scanner(new File(fileName)).useDelimiter("\\s*,\\s*|\\s*[\\n]+");
            ipr.nextLine(); // skip over header
            while(ipr.hasNextLine()) {
                System.out.print(String.format("%21s\t", ipr.next()));
                int ws = Integer.parseInt(ipr.next());
                int bs =Integer.parseInt(ipr.next());
                int s = Integer.parseInt(ipr.next());
                int t = Integer.parseInt(ipr.next());
                int w = Integer.parseInt(ipr.next());
                int i = Integer.parseInt(ipr.next());
                int a = Integer.parseInt(ipr.next());
                int ld = Integer.parseInt(ipr.next());
                int sv = Integer.parseInt(ipr.next());
                InfantryProfile ip = new InfantryProfile(ws,bs,s,t,w,i,a,ld,sv);
                profiles.add(ip);
                System.out.println(ip);
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Could not find file: %s", e.getMessage()));
        }
        return profiles;
    }

    public static ArrayList<Profile> getVehicleProfiles(String fileName) {
        ArrayList<Profile> profiles = new ArrayList<Profile>();
        try {
            Scanner vpr = new Scanner(new File(fileName)).useDelimiter("\\s*,\\s*|\\s*[\\n]+");
            vpr.nextLine(); // skip over header
            while(vpr.hasNextLine()) {
                System.out.print(String.format("%25s\t", vpr.next()));
                int ws = Integer.parseInt(vpr.next());
                int bs = Integer.parseInt(vpr.next());
                int s = Integer.parseInt(vpr.next());
                int f = Integer.parseInt(vpr.next());
                int si = Integer.parseInt(vpr.next());
                int r = Integer.parseInt(vpr.next());
                int i = Integer.parseInt(vpr.next());
                int a = Integer.parseInt(vpr.next());
                int hp = Integer.parseInt(vpr.next());

                VehicleProfile vp = new VehicleProfile(bs, f, si, r, hp);
                profiles.add(vp);
                System.out.println(vp);
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Could not find file: %s", e.getMessage()));
        }
        return profiles;
    }

    public static ArrayList<Profile> getWeaponProfiles(String fileName) {
        ArrayList<Profile> profiles = new ArrayList<Profile>();
        try {
            Scanner wpr = new Scanner(new File(fileName)).useDelimiter("\\s*,\\s*|\\s*[\\n]+");
            wpr.nextLine(); // skip over header
            while(wpr.hasNextLine()) {
                System.out.print(String.format("%32s\t", wpr.next()));
                int range = Integer.parseInt(wpr.next());
                int s = Integer.parseInt(wpr.next());
                int ap = Integer.parseInt(wpr.next());
                wpr.next(); // skip over type

                WeaponProfile wp = new WeaponProfile(range, s, ap);
                profiles.add(wp);
                System.out.println(wp);
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Could not find file: %s", e.getMessage()));
        }
        return profiles;
    }
}
