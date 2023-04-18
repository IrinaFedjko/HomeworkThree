import controllers.MenuController;

import javax.swing.*;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {

        JDialog stest = new JDialog();
        stest.setTitle("OUR SUPERMARKET BARBORA");
        stest.setVisible(true);
        stest.setSize(300, 100);
        stest.setLocation(800, 100);
        JLabel a = new JLabel("***You are welcome \n " + "in our supermarket!***");
        stest.add(a);

        MenuController supermarket = new MenuController();
        supermarket.start();


    }
}
