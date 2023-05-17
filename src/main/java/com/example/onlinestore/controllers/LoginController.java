package com.example.onlinestore.controllers;

import com.example.onlinestore.Main;
import com.example.onlinestore.exceptions.UsernameAlreadyExistsException;
import com.example.onlinestore.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.onlinestore.servicies.NitriteDB;

import java.io.IOException;

import static com.example.onlinestore.servicies.NitriteDB.encodePassword;

public class LoginController {



    @FXML
    private ComboBox rolecombobox;

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Label registration;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    private NitriteDB db;

    @FXML
    public void initialize() {
        rolecombobox.getItems().addAll("Client", "Admin");
        db = new NitriteDB();

    }


    @FXML
    public void onRegistrationButtonClick() {


        try {
            NitriteDB.addUser(usernamefield.getText(), passwordfield.getText(), (String) rolecombobox.getValue());
            registration.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registration.setText(e.getMessage());
        }


    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage-form.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */




        String username = usernamefield.getText();
        String password = passwordfield.getText();

        User user = db.getUser(username);

        if (username.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Username");
            alert.setContentText("The username you entered does not exist.");
            alert.showAndWait();
        } else {
            String hashedPassword = encodePassword(username, password);
            if (user.getPassword().equals(hashedPassword) && user.getUsername().equals(username) && user.getRole().equals((String) rolecombobox.getValue()) ) {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homepage-form.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText("Invalid Creditals");
                alert.setContentText("The password you entered is incorrect.");
                alert.showAndWait();
            }

        }

    }

}

