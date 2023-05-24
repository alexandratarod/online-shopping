package com.example.onlinestore.controllers;

import com.example.onlinestore.model.UserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.example.onlinestore.servicies.ProductDatabase;
import com.example.onlinestore.model.Product;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ManageProductsController implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private Button ClearButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TableColumn<Product, String> IDProduct_col;

    @FXML
    private Button ImportButton;

    @FXML
    private TableColumn<Product, String> Price_col;

    @FXML
    private TableColumn<Product, String> ProductName_col;

    @FXML
    private ImageView ProductsImageView;

    @FXML
    private TableView<Product> ProductsTableView;

    @FXML
    private Button ProductsfromManageProducts;

    @FXML
    private TableColumn<Product, String> Stock_col;

    @FXML
    private Button UpdateButton;

    @FXML
    private TextField idproductfield;

    @FXML
    private TextField pricefield;

    @FXML
    private TextField productnamefield;

    @FXML
    private TextField stockfield;



    @FXML
    private AnchorPane manageproductsform;

    private Stage stage;

    private Scene scene;

    private Parent root;

    private Image image;

    private ObservableList<Product> cardlist = FXCollections.observableArrayList();


    private ObservableList<Product> productslistdata;
    public void manageProductsShowData() {
        IDProduct_col.setCellValueFactory(new PropertyValueFactory<>("productId"));
        ProductName_col.setCellValueFactory(new PropertyValueFactory<>("productName"));
        Price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        Stock_col.setCellValueFactory(new PropertyValueFactory<>("stock"));

        productslistdata = FXCollections.observableArrayList(ProductDatabase.getAllProducts());
        ProductsTableView.setItems(productslistdata);

        cardlist.addAll(productslistdata);
    }


    @FXML
    protected void OnProductsButtonFromManageProductsClick(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("products-form.fxml"));

        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void OnAddButton(ActionEvent event){

        String productId = idproductfield.getText();
        String productName = productnamefield.getText();
        double price = Double.parseDouble(pricefield.getText());
        int stock = Integer.parseInt(stockfield.getText());
        String picture = "";

        Image image = ProductsImageView.getImage();
        if (image != null) {
            picture = image.getUrl().toString();
        }


        Product product = new Product(productId, productName, price, stock, picture);

        ProductDatabase.addProduct(product); // Call the method to add the product to the database

        clearFields(); // Clear the input fields after adding the product


    }

    private void clearFields() {
        idproductfield.clear();
        productnamefield.clear();
        pricefield.clear();
        stockfield.clear();

    }

    @FXML
    public void OnClearButton(ActionEvent event) {
        clearFields();
    }

    @FXML
    public void OnDeleteButton(ActionEvent event) {

    }



    @FXML
    public void OnImportButton(ActionEvent event) {
       FileChooser OpenFile = new FileChooser();
        OpenFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*png", "*jpg", "*.jpeg"));

        File file = OpenFile.showOpenDialog(manageproductsform.getScene().getWindow());

        if(file != null) {
            UserData.path = file.getAbsolutePath();

         image = new Image(file.toURI().toString(),77, 85, false, true);

         ProductsImageView.setImage(image);
        }
    }

    @FXML
    public void OnUpdateButton(ActionEvent event) {
        // Get the selected product from the TableView
        Object selectedProduct = ProductsTableView.getSelectionModel().getSelectedItem();

        if (selectedProduct != null && selectedProduct instanceof Product) {
            Product productToUpdate = (Product) selectedProduct;

            // Retrieve updated values from input fields
            String newProductId = idproductfield.getText();
            String newProductName = productnamefield.getText();
            double newPrice = Double.parseDouble(pricefield.getText());
            int newStock = Integer.parseInt(stockfield.getText());


            // Update the product object
            productToUpdate.setProductId(newProductId);
            productToUpdate.setProductName(newProductName);
            productToUpdate.setPrice(newPrice);
            productToUpdate.setStock(newStock);

            // Update the product in the database
            ProductDatabase.updateProduct(productToUpdate);

            // Refresh the TableView
            ProductsTableView.refresh();

            // Clear the input fields
            clearFields();
        }
    }

    public ObservableList<Product> getCardList() {
        return cardlist;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manageProductsShowData();
    }
}
