package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Answer implements Serializable {
    private String id;
    private String answer;

    @Override
    public String toString() {
        return answer;
    }
}
