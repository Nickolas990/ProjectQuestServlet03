package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
public class Dialogue implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger("rollingFile");
    private transient ArrayList<Block> blocks = new ArrayList<>();

    public static Dialogue initialize(String characterName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dialogue dialogue = null;
        try (InputStream fileFromResource = getFileFromResource("dialogs/" + characterName + ".json");
             BufferedReader src = new BufferedReader(new InputStreamReader(fileFromResource, StandardCharsets.UTF_8))) {
            dialogue = objectMapper.readValue(src, Dialogue.class);
        } catch (IOException e) {
            logger.error("Message:{0}. There was a problem with the *.json file. Check that it is in the settings root directory and matches the your class", e);
        }
        return dialogue;
    }

    public Block getBlockById(String id) {
        if (Objects.nonNull(id) && Objects.nonNull(blocks)) {
            Optional<Block> result = blocks.stream()
                    .filter(block -> block.getId().equals(id))
                    .findFirst();
            if (result.isPresent()) {
                return result.get();
            } else {
                throw new IllegalArgumentException("No such block found");
            }
        }
        throw new IllegalArgumentException("Blocks missed");
    }

    private static InputStream getFileFromResource(String filename) {
        InputStream resource = Dialogue.class.getClassLoader().getResourceAsStream(filename);
        if (Objects.isNull(resource)) {
            throw new IllegalArgumentException("File of Dialogue not found");
        } else {
            return resource;
        }
    }
}