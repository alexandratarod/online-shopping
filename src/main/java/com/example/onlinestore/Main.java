package com.example.onlinestore;

import com.example.onlinestore.servicies.FileSystemService;
import com.example.onlinestore.servicies.NitriteDB;
import com.example.onlinestore.servicies.ProductDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        initDirectory();
        NitriteDB.initDatabase();
        ProductDatabase.initDatabase();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("login-form.fxml"));
        Scene scene = new Scene(loader.load(), 700, 410);
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