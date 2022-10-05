package com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons.abstraction.Weapon;

import java.util.stream.DoubleStream;

public class Knife extends Weapon {

    public Knife() {
        setDamage(10);
        setWeight(1);
        setName("knife");
        setImage("<img src=\"images/items/weapons/knife.png\" class=\"img-fluid\"/>");

    }
}
