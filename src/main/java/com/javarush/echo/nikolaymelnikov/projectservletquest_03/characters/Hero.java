package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Character;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.interfaces.Movable;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Hero extends Character implements Movable {

    private GameMap gameMap;
    private Location currentLocation;
    private Map<String, Integer> inventory;

    public Hero(GameMap gameMap) {
        this.gameMap = gameMap;
        currentLocation = gameMap.getStartLocation();
        inventory = new HashMap<>();
        currentHealth = maxHealth;
        stamina = 10;
        strength = 20;
        defence = 30;
    }

    @Override
    public void move(Location location) {
        currentLocation = location;
    }

}
