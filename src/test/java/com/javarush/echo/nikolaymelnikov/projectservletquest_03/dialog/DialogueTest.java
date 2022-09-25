package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DialogueTest {

    Dialogue dialogue;



    @Test
    void test_initialize_with_wrong_file() {
        assertThrows(RuntimeException.class, () -> dialogue = Dialogue.initialize("test"));
    }

    @Test
    void test_getBlockById_if_chosen_wrong_block() {
        dialogue = Dialogue.initialize("Grentias");
        assertThrows(IllegalArgumentException.class, () -> dialogue.getBlockById("test"));
    }
    @Test
    void test_getBlockById_if_blocks_is_not_initialised() {
        assertThrows(IllegalArgumentException.class, () -> new Dialogue().getBlockById("test"));
    }
}