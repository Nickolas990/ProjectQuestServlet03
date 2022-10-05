package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Block {
    private String id;
    private String question;
    private Answer[] answers;
}
