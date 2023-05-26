package com.example.onlinestore;

import com.example.onlinestore.controllers.PlaceOrderController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceOrderControllerTest extends ApplicationTest {

    private PlaceOrderController controller;
    private Scene scene;

    @BeforeEach
    public void setup() throws IOException {
        // Load the FXML file and create the controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/place-order.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        // Set up the stage and scene
        Stage stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // No need to implement this method for this test
    }

    @Test
    public void testOnCartButtonFromPlaceOrderClick() {
        // Simulate button click
        clickOn("#CartButtonFromPlaceOrder");

        // Verify that the scene has changed
        assertEquals("cart-form.fxml", scene.getRoot().getId());
    }

    @Test
    public void testOnPlaceOrderButtonClick() {
        // Set values for the text fields
        TextField firstnameField = lookup("#firstname_field").query();
        TextField lastnameField = lookup("#lastname_field").query();
        TextField cityField = lookup("#city_field").query();
        TextField streetField = lookup("#street_field").query();
        TextField postalcodeField = lookup("#postalcode_field").query();

        firstnameField.setText("John");
        lastnameField.setText("Doe");
        cityField.setText("New York");
        streetField.setText("Main Street");
        postalcodeField.setText("12345");

        // Simulate button click
        clickOn("#placeOrderButton");

        // Verify that the fields are cleared
        assertTrue(firstnameField.getText().isEmpty());
        assertTrue(lastnameField.getText().isEmpty());
        assertTrue(cityField.getText().isEmpty());
        assertTrue(streetField.getText().isEmpty());
        assertTrue(postalcodeField.getText().isEmpty());
    }
}
