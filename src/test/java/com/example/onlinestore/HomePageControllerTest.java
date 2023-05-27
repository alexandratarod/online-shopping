package com.example.onlinestore;

import com.example.onlinestore.controllers.HomePageController;
//import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HomePageControllerTest {


    @Test
    public void testOnLoginButtonClick() {
        HomePageController controller = new HomePageController();
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> controller.onLogoutButtonClick(event));
    }

    @Test
    public void testOnSignUpButtonClick() {
        HomePageController controller = new HomePageController();
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> controller.onOurProductsButtonClick(event));
    }


}
