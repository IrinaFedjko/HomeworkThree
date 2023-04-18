package controllers;

import usersAndProducts.Products;
import usersAndProducts.ShoppingCart;

import javax.swing.*;

public class ShoppingCartController {

    MenuController menuController = new MenuController();

        public void collectAndSaveProductsInShoppingCart(){
            try{
                this.menuController.addProductsToABusket(this.collectProductsInfo());
                JOptionPane.showMessageDialog(null, "Product was added successfully");

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }


        private ShoppingCart collectProductsInfo() {
            Products products = new Products();
            String productName = JOptionPane.showInputDialog(null, "Please choose a product");
            products.setName(productName);
            Integer quantityofThisProduct = Integer.valueOf(JOptionPane.showInputDialog(null, "Write quantity"));
            products.setQuantity(quantityofThisProduct);
            Double weightOfThisProduct = Double.valueOf(JOptionPane.showInputDialog(null, "Please write weight"));
            products.setWeight(weightOfThisProduct);
            Double priceOfThisProduct = Double.valueOf(JOptionPane.showInputDialog(null, "Please write price"));
            products.setPrice(priceOfThisProduct);
return  null;
        }
    }


