package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Dialogue;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.quests.Quest;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class QuestGiver extends Character {
    private Quest quest;
    private Dialogue dialog;

    public QuestGiver(String name) {
        this.setName(name);
        dialog = Dialogue.initialize(name);
    }
}
