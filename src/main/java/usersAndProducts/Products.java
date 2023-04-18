package usersAndProducts;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor


public class Products {
    public int id;
    public String name;
    public int quantity;
    public Double weight;
    public Double price;

    public Products(String name, int quantity, Double price, double weight) {
    }


    @Override
    public String toString() {
        return " name = " + name + ", \n" +
                "quantity = " + quantity + ", \n" +
                " price = " + price + " $" + ", \n" +
                " weight = " + weight;
    }

}
