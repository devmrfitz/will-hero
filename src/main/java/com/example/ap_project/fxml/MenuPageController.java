package com.example.ap_project.fxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private FileChooser fileChooser;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void exitGame(ActionEvent event) {
        System.out.println("exit clicked");
        Stage stage = (Stage)((Node) (event.getSource())).getScene().getWindow();
        stage.close();
    }

    @FXML
    void gameStart(ActionEvent event) throws IOException {
        System.out.println("play clicked");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getResource("game.fxml")));
        scene = loader.load();
        //Move back a little to get a good view of the sphere
        stage = (Stage)((Node) (event.getSource())).getScene().getWindow();
        GameController.setStage(stage);
//        ((GameController)(loader.getController())).setStage(stage);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaxWidth(900);
        stage.setMaxHeight(480);
        stage.show();

    }

    @FXML
    void loadGame(ActionEvent event) {
        System.out.println("load clicked");
        fileChooser = new FileChooser();
        fileChooser.setTitle("Save Dialog");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file","*.txt"));
        try{
            File file = fileChooser.showOpenDialog(stage);
            //load file here
            System.out.println(file.getAbsolutePath());
        }
        catch (Exception e){
            System.out.println("error");
        }

    }

    @FXML
    void initialize() {

    }

}