package com.example.ap_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class gameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}