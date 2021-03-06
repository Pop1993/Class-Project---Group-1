package Entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="product_name", unique = true, nullable = false, length = 30)
    private String productName;

    @Column(nullable = false)
    private int amount;

    @Column
    private int price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderProduct> orderProducts;


    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
