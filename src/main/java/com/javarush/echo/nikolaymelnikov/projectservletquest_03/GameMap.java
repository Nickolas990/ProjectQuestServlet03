package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.NPC;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GameMap implements Serializable {
    private Map<String, Location> map = new HashMap<>();
    private Location startLocation;

    public GameMap () {
    }

    public void setConnection(Location location01, Location location02) {
        location02.getConnectedLocations().add(location01);
        location01.getConnectedLocations().add(location02);
    }
    public void placeCharacter(Location location01, NPC NPC) {
        location01.getNPCInLocation().add(NPC);
    }


}
