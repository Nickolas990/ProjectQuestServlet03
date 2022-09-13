package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Character;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.interfaces.Backpack;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.interfaces.Movable;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.quests.Quest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Hero extends Character implements Movable, Serializable, Backpack {

    private GameMap gameMap;
    private Location currentLocation;
    private List<Item> inventory;

    private Quest currentQuest;
    private int experience = 0;
    private int expToNextLevel = 100;

    public Hero(GameMap gameMap) {
        this.gameMap = gameMap;
        currentLocation = gameMap.getStartLocation();
        inventory = new ArrayList<>();
        currentHealth = maxHealth;
        stamina = 10;
        strength = 20;
        defence = 30;
    }

    @Override
    public void move(Location location) {
        currentLocation = location;
    }

    @Override
    public boolean take(Item item) {
        if (currentLocation.getItemsInLocation().contains(item)) {
            inventory.add(item);
            currentLocation.getItemsInLocation().remove(item);
            return true;
        } else {
            return false;
        }
    }
}
