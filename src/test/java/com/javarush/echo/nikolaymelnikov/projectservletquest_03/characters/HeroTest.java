package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;


import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.mapcreator.DefaultMapCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {


    @Test
    void move_throw_exception_if_location_not_real() {
        assertThrows(IllegalStateException.class, () -> new Hero(DefaultMapCreator.create()).move(new Location("Phantasy")));
    }

    @Test
    void take() {
    }

    @Test
    void give() {
    }
}