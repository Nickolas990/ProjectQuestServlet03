package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.NPC;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Location {
    private String nameOfLocation;
    private List<NPC> NPCInLocation = new ArrayList<>();
    private List<Location> connectedLocations = new ArrayList<>();

    private List<Item> itemsInLocation = new ArrayList<>();
    private String locationImage;

    public Location(String nameOfLocation) {
        this.nameOfLocation = nameOfLocation;
        locationImage = "<img src=\"images/locationImages/" + nameOfLocation + ".jpg\"/>";
    }
    public void setConnectedLocations(Location...locations) {
        Arrays.stream(locations).forEach(e -> connectedLocations.add(e));
    }
    public void placeCharacter(NPC NPC) {
        NPCInLocation.add(NPC);
    }

    @Override
    public String toString() {
        return nameOfLocation;
    }
}