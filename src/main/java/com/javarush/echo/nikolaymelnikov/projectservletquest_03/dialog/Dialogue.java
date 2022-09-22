package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Getter
@Setter
public class Dialogue implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger("rollingFile");
    private Block[] blocks;

    public static Dialogue initialize(String characterName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dialogue dialogue = null;
        try {
            dialogue = objectMapper.readValue(new BufferedReader(new InputStreamReader(getFileFromResource("dialogs/" + characterName + ".json"), StandardCharsets.UTF_8)), Dialogue.class);
        } catch (IOException | URISyntaxException e) {
            logger.error(e + " There was a problem with the *.json file. Check that it is in the settings root directory and matches the your class");
            new RuntimeException(e + " There was a problem with the *.json file. Check that it is in the settings root directory and matches the your class");
        }
        return dialogue;
    }

    public Block getBlockById(String id) {
        if (Objects.nonNull(id) && Objects.nonNull(blocks)) {
            for (Block block : blocks) {
                if (block.getId().equals(id)) {
                    return block;
                }
            }
            throw new IllegalArgumentException("No such block found");
        }
        throw new IllegalArgumentException("Blocks missed");
    }
    private static InputStream getFileFromResource(String filename) throws URISyntaxException {
        InputStream resource = Dialogue.class.getClassLoader().getResourceAsStream(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File of Dialogue not found");
        } else {
            return resource;
        }
    }
}