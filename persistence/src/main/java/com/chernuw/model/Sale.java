package com.chernuw.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="footwear_id")
    private Footwear footwear;

    @NotNull
    private int amount;

    public Sale() {
        this(null, 0);
    }

    public Sale(Footwear footwear) {
        super();
        this.footwear = footwear;
        this.amount = 0;
    }

    public Sale(Footwear footwear, int amount) {
        super();
        this.footwear = footwear;
        this.amount = amount;
    }

    public void amountIncrement() {
        this.amount++;
    }

    public void amountDecrement() {
        this.amount--;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Footwear getFootwear() {
        return footwear;
    }

    public void setFootwear(Footwear footwear) {
        this.footwear = footwear;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sale)) {
            return false;
        }
        Sale sale = (Sale)obj;
        return footwear.getName().equals(sale.footwear.getName());
    }

    public int hashCode() {
        return Objects.hash(footwear);
    }
}
