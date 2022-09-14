package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class NPC {
    private String name;
    private int id;
    private int level;
    private Location currentLocation;
    protected int maxHealth = 100;
    protected int currentHealth;
    private List<Item> inventory;

    protected int strength;
    protected int stamina;
    protected int defence;

    public List<Item> getInventory() {
        return inventory;
    }

    public NPC() {

    }

    @Override
    public String toString() {
        return name;
    }
}
