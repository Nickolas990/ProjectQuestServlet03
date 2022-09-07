package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Character;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GameMap {
    private Map<String, Location> map = new HashMap<>();
    private Location startLocation;

    public GameMap () {
    }

    public void setConnection(Location location01, Location location02) {
        location02.getConnectedLocations().add(location01);
        location01.getConnectedLocations().add(location02);
    }
    public void placeCharacter(Location location01, Character character) {
        location01.getCharacterInLocation().add(character);
    }


}
