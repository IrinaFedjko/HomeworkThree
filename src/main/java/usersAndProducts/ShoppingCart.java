package usersAndProducts;

import lombok.*;

import javax.swing.*;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class ShoppingChart {

    private String customerName;
    private String productName;
    private int quantity;
    private double weight;

ArrayList<ShoppingChart> shoppingCharts = new ArrayList<>();
 if (shoppingCharts.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No contacts to display");
        return 0;
    }
}
