package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DialogueTest {

    @Test
    void Test_initialize__with_wrong_file() {
        assertThrows(RuntimeException.class, () -> Dialogue.initialize("something"));
    }

    @Test
    void getBlockById_Test() {
        assertThrows(IllegalArgumentException.class, () -> new Dialogue().getBlockById("impossible"));
    }
}