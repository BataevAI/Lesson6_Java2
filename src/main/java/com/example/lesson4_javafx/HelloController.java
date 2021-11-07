package com.example.lesson4_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;





    @FXML
    public void ClickSendButton(ActionEvent actionEvent) {
        final String message = messageField.getText();
        if (message.isEmpty()) {
            return;
        }
        messageArea.appendText(message + "\n");
        messageField.setText("");
        messageField.requestFocus();

    }


    public void exitSelect(ActionEvent actionEvent) {

        System.exit(0);
    }


    public void ClickButton1(ActionEvent actionEvent) {

        final Button source = (Button) actionEvent.getSource();
        messageArea.appendText(source.getText() + "\n");
        messageField.setText("");
        messageField.requestFocus();


    }
}