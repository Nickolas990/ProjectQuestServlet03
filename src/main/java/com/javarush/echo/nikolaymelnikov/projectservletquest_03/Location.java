package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Character;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Location {
    private String nameOfLocation;
    private Set<Character> characterInLocation = new HashSet<>();
    private List<Location> connectedLocations = new ArrayList<>();

    private String locationImage;

    public Location(String nameOfLocation) {
        this.nameOfLocation = nameOfLocation;
        locationImage = "<img src=\"/locationImages/" + nameOfLocation + ".jpg\"/>";
    }
    public void setConnectedLocations(Location...locations) {
        Arrays.stream(locations).forEach(e -> connectedLocations.add(e));
    }

    @Override
    public String toString() {
        return nameOfLocation;
    }
}