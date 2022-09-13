package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private String id;
    private String answer;

    @Override
    public String toString() {
        return answer;
    }
}
