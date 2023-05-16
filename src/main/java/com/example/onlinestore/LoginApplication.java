package com.example.onlinestore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;

public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        initDirectory();
        NitriteDB.initDatabase();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 410);
        stage.setTitle("A&F Makeup Store");
        stage.setScene(scene);
        stage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) {


        launch();
    }
}