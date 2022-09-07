package com.javarush.echo.nikolaymelnikov.projectservletquest_03.mapcreator;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;

import java.util.Map;

public class DefaultMapCreator {
    public static GameMap create() {
        GameMap newMap = new GameMap();
        newMap.getMap().put("Entrance", new Location("Entrance"));
        newMap.getMap().put("Bathroom", new Location("Bathroom"));
        newMap.getMap().put("Garden", new Location("Garden"));
        newMap.getMap().put("Wardrobe", new Location("Wardrobe"));
        newMap.getMap().put("Living Room", new Location("Living Room"));
        newMap.getMap().put("Kitchen", new Location("Kitchen"));
        newMap.getMap().put("Basement", new Location("Basement"));
        newMap.getMap().put("Bedroom", new Location("Bedroom"));

        Map<String, Location> house = newMap.getMap();

        house.get("Entrance").setConnectedLocations(house.get("Living Room"));
        house.get("Living Room").setConnectedLocations(house.get("Entrance"),
                house.get("Bathroom"),
                house.get("Wardrobe"),
                house.get("Kitchen"),
                house.get("Bedroom"));
        house.get("Bathroom").setConnectedLocations(house.get("Living Room"));
        house.get("Wardrobe").setConnectedLocations(house.get("Living Room"));
        house.get("Kitchen").setConnectedLocations(house.get("Living Room"));
        house.get("Bedroom").setConnectedLocations(house.get("Living Room"), house.get("Basement"));
        house.get("Basement").setConnectedLocations(house.get("Living Room"));

        newMap.setStartLocation(newMap.getMap().get("Entrance"));

        return newMap;
    }
}
