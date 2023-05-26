package com.example.onlinestore;

import com.example.onlinestore.controllers.CartController;
import com.example.onlinestore.model.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartControllerTest extends ApplicationTest {

    private CartController cartController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cart-form.fxml"));
        Parent root = loader.load();
        cartController = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void testShowTotalPrice() {
        cartController.cartList.add(new Product("Product 1", 10.0));
        cartController.cartList.add(new Product("Product 2", 20.0));

        cartController.ShowTotalPrice();

        assertEquals("30.0 $", cartController.getTotalPriceLabelText());
    }

    @Test
    public void testCalculateTotalPrice() {
        cartController.cartList.add(new Product("Product 1", 10.0));
        cartController.cartList.add(new Product("Product 2", 20.0));

        double totalPrice = cartController.calculateTotalPrice();

        assertEquals(30.0, totalPrice);
    }

  /*  @Test
    public void testPlaceOrderButtonClick(FxRobot robot) throws IOException {
        // Simulate button click
        robot.clickOn(cartController.getPlaceorderButtonFormCart());

        // Assert the expected behavior after the button click
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("placeorder-form.fxml"));
        Parent expectedRoot = loader.load();

        assertEquals(expectedRoot, cartController.getRoot());
        // You can also assert other properties of the expected scene or stage
    }

   */
}
