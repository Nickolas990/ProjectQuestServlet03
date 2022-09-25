package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.interfaces.Backpack;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.interfaces.Movable;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.quests.Quest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Hero extends NPC implements Movable, Serializable, Backpack {

    private GameMap gameMap;
    private Location currentLocation;

    private Quest currentQuest;
    private int experience = 0;
    private int expToNextLevel = 100;

    public Hero(GameMap gameMap) {
        this.gameMap = gameMap;
        currentLocation = gameMap.getStartLocation();
        currentHealth = maxHealth;
        stamina = 10;
        strength = 20;
        defence = 30;
    }

    @Override
    public void move(Location location) {
        if(getGameMap().getMap().containsKey(location.getNameOfLocation())){
            currentLocation = location;
        } else throw new IllegalStateException("This place is not created by our Gods");

    }

    @Override
    public boolean take(Item item) {
        if (currentLocation.getItemsInLocation().contains(item)) {
            getInventory().add(item);
            currentLocation.getItemsInLocation().remove(item);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean give(Item item, NPC NPC) {
        if (getInventory().contains(item)) {
            getInventory().remove(item);
            NPC.getInventory().add(item);
        }
        return false;
    }
}
