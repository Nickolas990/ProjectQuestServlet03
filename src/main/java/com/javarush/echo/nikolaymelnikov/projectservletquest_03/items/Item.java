package com.javarush.echo.nikolaymelnikov.projectservletquest_03.items;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    private String name;
    private int weight;
    private String imageFile;
    private String image = String.format("<img src=\"%s\" class=\"img-fluid\"/>", imageFile);

    @Override
    public String toString() {
        return name;
    }
}
