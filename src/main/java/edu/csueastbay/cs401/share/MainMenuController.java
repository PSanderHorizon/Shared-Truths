package edu.csueastbay.cs401.share;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {

    @FXML
    private BorderPane baseBorderPane;
    @FXML
    private Label titleLabel;

    @FXML
    void studentButtonClick(ActionEvent event) {
        Button button = (Button)event.getTarget();
        titleLabel.setText(button.getText() + " is sharing");
        switch (button.getText()) {
            case "Paul Raupach" -> loadStudentPane("/edu/csueastbay/cs401/praupach/reveal.fxml");
            case "Bob Smith" -> loadStudentPane("/edu/csueastbay/cs401/bsmith/reveal.fxml");
            case "Joshua Rodriguez" -> loadStudentPane("/edu/csueastbay/cs401/jrodriguez/reveal.fxml");
            default -> System.out.println("huh?");
        }
    }

    private void loadStudentPane(String template) {

        try {
            Parent root;
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(template)));
            baseBorderPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
