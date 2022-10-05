package com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons.abstraction.Weapon;

public class Uzi extends Weapon {
    public Uzi() {
        setDamage(10000);
        setWeight(0);
        setName("Uzi");
        setImage("images/weapons/uzi.png");
    }
}
