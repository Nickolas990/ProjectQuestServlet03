package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DialogueTest {

    Dialogue dialogue;

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