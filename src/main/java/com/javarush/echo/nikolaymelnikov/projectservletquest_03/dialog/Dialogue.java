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
    private static final Logger logger = LoggerFactory.getLogger(Dialogue.class);
    private transient ArrayList<Block> blocks = new ArrayList<>();

    public static Dialogue initialize(String characterName) {
        logger.info("{} started", Dialogue.class.getSimpleName());
        ObjectMapper objectMapper = new ObjectMapper();
        Dialogue dialogue = null;
        try (InputStream fileFromResource = getFileFromResource("dialogs/" + characterName + ".json");
             BufferedReader src = new BufferedReader(new InputStreamReader(fileFromResource, StandardCharsets.UTF_8))) {
            dialogue = objectMapper.readValue(src, Dialogue.class);
        } catch (IOException e) {
            logger.error("Message: {}. There was a problem with the *.json file. Check that it is in the settings root directory and matches the your class", e.getMessage());
        }
        return dialogue;
    }

    public Block getBlockById(String id) {
        logger.info("{} selected", id);
        if (Objects.nonNull(id) && Objects.nonNull(blocks)) {
            Optional<Block> result = blocks.stream()
                    .filter(block -> block.getId().equals(id))
                    .findFirst();
            if (result.isPresent()) {
                return result.get();
            } else {
                logger.error("In ID {} suitable block did not found", id);
                throw new IllegalArgumentException("No such block found " + id);
            }
        }
        logger.error("In ID: {} Blocks did not found", id);
        throw new IllegalArgumentException("Blocks missed " + id);
    }

    private static InputStream getFileFromResource(String filename) {
        InputStream resource = Dialogue.class.getClassLoader().getResourceAsStream(filename);
        if (Objects.isNull(resource)) {
            logger.error("{} file missed", filename);
            throw new IllegalArgumentException("File of Dialogue not found");
        } else {
            return resource;
        }
    }
}