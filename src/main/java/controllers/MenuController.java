package controllers;

import sqlConnector.SQLConnector;
import usersAndProducts.Customers;
import usersAndProducts.Products;
import usersAndProducts.ShoppingCart;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuController {

    //private final CustomerDataCollector customerDataCollector = new CustomerDataCollector();
//private final ShoppingCartController  shoppingCartController = new ShoppingCartController();
    public void start() throws SQLException {
        this.option();
    }

    private Object option() throws SQLException {
        String option = this.getUserInput("Hello to our supermarket!\n" +
                "Write the number for activity you want to perform\n" +
                "1.Make registration if you are a new user!\n" +
                "2.Enter password to continue for employee!\n" +
                "3.Check all products in our supermarket!\n" +
                "4.Add products to a basket!\n" +
                "5.Remove item from a basket!\n" +
                "6.Check your basket\n" +
                "7.Make payment\n" +
                "8.Close/Exit\n");

        switch (option) {
            case "1":
                this.makeRegistration();
                break;
            case "2":
                this.enterPasswordToContinueForEmployeesOnly();
                break;
            case "3":
                this.checkAllProducts();
                break;
            case "4":
                this.collectAndSaveProductsInShoppingCart(this.collectProductsInfo());
                break;
            case "5":
                this.removeItemFromBasket();
                break;
            case "6":
                this.checkBasket();
                break;
            case "7":
                this.makePayment();
                break;
            case "8":
                JOptionPane.showMessageDialog(null, "Good buy!");
                break;
        }
        System.exit(0);

        return null;
    }

    private ShoppingCart collectProductsInfo() {
        return null;
    }

    private String getUserInput(String message) {
        return JOptionPane.showInputDialog(message);
    }

    private int makeRegistration() throws SQLException {
        try {
            CustomerDataCollector customerDataCollector = new CustomerDataCollector();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        String password = this.getUserInput("Create your password");
        String name = this.getUserInput("Enter your name, obligatory ");
        if (name == null) {
            this.getUserInput("Enter name");
        }
        this.getUserInput("Enter your surname");
        String email = this.getUserInput("Enter your email, obligatory");
        if (email == null) {
            this.getUserInput("Enter your email");
        }
        this.getUserInput("Enter your address");
        JOptionPane.showMessageDialog(null, "Welcome " + name + " registration was successful");
        JOptionPane.showMessageDialog(null, option());
        Connection conn = SQLConnector.getConnection();
        Statement statement = conn.createStatement();
        Customers clients = new Customers();
        statement.executeUpdate("INSERT INTO clients (name, secondName, email, address) VALUES ('" + clients.getName() + "'', '" + clients.getSecondName() + "', '" + clients.getEmail() + "', '" + clients.getAddress() + ")");
        option();
        return 0;

    }

    private Integer enterPasswordToContinueForEmployeesOnly() throws SQLException {
        int pass = 1234;
        int password = Integer.parseInt(this.getUserInput("Write your password"));
        if (password == pass) {
            JOptionPane.showMessageDialog(null, "Correct", "Correct password.", JOptionPane.INFORMATION_MESSAGE);
            checkAllProducts();
        } else JOptionPane.showMessageDialog(null, "Wrong password", "Password", JOptionPane.ERROR_MESSAGE);
        return (Integer) option();
    }


    private Integer checkAllProducts() {
        try {
            Connection conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            List<Products> products = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                double weight = resultSet.getDouble("weight");
                int quantity = resultSet.getInt("quantity");
                Products product = new Products(id, name, quantity, price, weight);
                products.add(product);
                System.out.println(product);
                JOptionPane.showMessageDialog(null, product, "All products", JOptionPane.INFORMATION_MESSAGE);
            }
            option();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void makePayment() {

    }

    Object collectAndSaveProductsInShoppingCart(ShoppingCart shoppingCart) throws SQLException {
        String password = this.getUserInput("Write your password");
        CustomerDataCollector c = new CustomerDataCollector();
        c.getPassword();
        if (password.equals(c.getPassword())) {
            JOptionPane.showMessageDialog(null, "Correct", "Correct password.", JOptionPane.INFORMATION_MESSAGE);
            ShoppingCartController shoppingCartController = new ShoppingCartController();
            shoppingCartController.collectAndSaveProductsInShoppingCart();
            return option();
        } else JOptionPane.showMessageDialog(null, "Wrong password", "Password", JOptionPane.ERROR_MESSAGE);
        return option();

    }

    private Object removeItemFromBasket() throws SQLException {
        Integer password = Integer.valueOf(JOptionPane.showInputDialog("Write your password"));
        CustomerDataCollector c = new CustomerDataCollector();
        c.getPassword();
        if (password.equals(c.getPassword())) {
            JOptionPane.showMessageDialog(null, "Correct", "Correct password.", JOptionPane.INFORMATION_MESSAGE);
            String removeProduct = this.getUserInput("Choose product to delete from basket.");
            ShoppingCart sc = new ShoppingCart();
//                sc.removeProduct(removeProduct);
//                this.getUserInput(removeProduct + " - removed from basket.");
//                return option();
        } else JOptionPane.showMessageDialog(null, "Wrong password", "Password", JOptionPane.ERROR_MESSAGE);
        return option();
    }


    private void checkBasket() {
        try {
            ShoppingCart shoppingCart = new ShoppingCart();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void addProductsToABusket(ShoppingCart collectProductsInfo) {


    }
}



