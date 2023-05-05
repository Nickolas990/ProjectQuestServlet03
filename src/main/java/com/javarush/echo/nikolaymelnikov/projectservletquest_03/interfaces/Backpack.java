package com.javarush.echo.nikolaymelnikov.projectservletquest_03.interfaces;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.NPC;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;

public interface Backpack {
    boolean take(Item item);
    boolean give(Item item, NPC character);
}
