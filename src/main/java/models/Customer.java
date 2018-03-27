package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {
    private int id;
    private String name;
    private Basket basket;

    public Customer() {
    }


    public Customer(String name) {
        this.name = name;
        this.basket = null;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy="customer")
//    @PrimaryKeyJoinColumn
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
