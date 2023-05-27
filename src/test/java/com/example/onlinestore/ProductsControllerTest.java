package com.example.onlinestore;

import com.example.onlinestore.controllers.ProductsController;
//import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ProductsControllerTest {

    ProductsController productsController;

    /*@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("products-form.fxml"));
        Parent root = loader.load();
        productsController = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }*/

    @Test
    public void testOnHomeButtonFromProductsClick() {
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> productsController.onHomeButtonFromProductsClick(event));
    }

    @Test
    public void testOnCartButtonFromProductsClick() {
        ProductsController controller = new ProductsController();
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> productsController.onCartButtonFromProductsClick(event));
    }

    @Test
    public void testOnManageProductsButtonClick() {
        ProductsController controller = new ProductsController();
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> productsController.OnManageProductsButtonClick(event));
    }

    @Test
    public void testOnOrdersForAdminButton() {
        ProductsController controller = new ProductsController();
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> productsController.OnOrdersForAdminButton(event));
    }

    @Test
    public void testOnOrdersForClientButton() {
        ProductsController controller = new ProductsController();
        ActionEvent event = new ActionEvent();

        assertDoesNotThrow(() -> productsController.OnOrdersForClientButton(event));
    }
}
