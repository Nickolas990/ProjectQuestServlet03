package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Dialogue;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.quests.Quest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class QuestGiver extends NPC {
    private Quest quest;
    private Dialogue dialog;

    public QuestGiver(String name) {
        this.setName(name);
        dialog = Dialogue.initialize(name);
        setInventory(new ArrayList<>());
    }
}
