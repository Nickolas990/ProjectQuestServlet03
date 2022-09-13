package com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Block {
    private String id;
    private String question;
    private Answer[] answers;

    public String prepareForHtml() {
        String result = question.replace("\n", "<br>");
        if (result.contains("image")) {
            result.replace("image", "");
            result += "<p><img src=\"/images/" + id + ".jpeg\"></p>";
        }
        return result;
    }

    public String showAnswers() {
        StringBuilder sb = new StringBuilder();
        Arrays.asList(answers).forEach(answer -> sb.append("<p><input type=\"radio\" name=\"id\" value=" + answer.getId() + ">" + answer.getAnswer() + "</p><br>"));
        sb.append("<p><input type=\"submit\"></p>");
        return sb.toString();
    }
}
