package com.example.onlinestore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button LoginButton;

    @FXML
    private ComboBox rolecombobox;

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private PasswordField registrationmessage;

    private Stage stage;
    private Scene scene;

    private Parent root;

    private NitriteDB db;

    @FXML
    public void initialize() {
        rolecombobox.getItems().addAll("Client", "Admin");
        db = new NitriteDB();

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

        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Username");
            alert.setContentText("The username you entered does not exist.");
            alert.showAndWait();
        } else if (!user.getPassword().equals(password)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Password");
            alert.setContentText("The password you entered is incorrect.");
            alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage-form.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }

    }



    @FXML
    public void onRegistrationButtonClick() {
        try {
            NitriteDB.addUser(usernamefield.getText(), passwordfield.getText(), (String) rolecombobox.getValue());
            registrationmessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationmessage.setText(e.getMessage());
        }
    }



}