package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class NPC {

    protected int maxHealth = 100;
    protected int currentHealth;
    protected int strength;
    protected int stamina;
    protected int defence;
    private List<Item> inventory = new ArrayList<>();
    private String name;
    private int id;
    private int level;
    private Location currentLocation;

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return name;
    }
}
