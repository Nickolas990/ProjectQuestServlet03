package com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons.abstraction;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Weapon extends Item {
    private int damage;
}
