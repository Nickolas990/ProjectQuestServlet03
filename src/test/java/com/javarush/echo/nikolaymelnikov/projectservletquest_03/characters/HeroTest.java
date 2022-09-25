package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;


import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons.Knife;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.weapons.Uzi;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.mapcreator.DefaultMapCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroTest {


    private Location location = new Location("test");
    private Hero hero = new Hero();
    private Knife knife = new Knife();

    private List<Item> itemsInLocation;

    private Item item;

    @BeforeEach
    void init() {
        hero.setCurrentLocation(location);
        location.getItemsInLocation().add(knife);
    }

    @Test
    void move_throw_exception_if_location_not_real() {
        assertThrows(IllegalStateException.class, () -> new Hero(DefaultMapCreator.create()).move(new Location("Phantasy")));
    }


    @Test
    void test_take_item() {
        assertTrue(hero.take(knife));
    }

    @Test
    void test_take_wrong_item() {
        assertFalse(hero.take(new Uzi()));
    }

    @Test
    void give() {
    }
}