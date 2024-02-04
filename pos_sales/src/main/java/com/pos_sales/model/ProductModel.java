package com.pos_sales.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;

    private String productname;
    private int quantity;
    private double price;
    private boolean isDeleted;
    private int purchaseCount;

    @Column(unique = false)
    @ManyToMany
    public List<AccountsModel> accounts;

    public ProductModel() {
    }

    public ProductModel(int productid, String productname, int quantity, double price, int purchaseCount, List<AccountsModel> accounts) {
        this.productid = productid;
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
        this.purchaseCount = purchaseCount;
        this.accounts = accounts;
    }

    public List<AccountsModel> getAccounts() {
        return accounts;
    }

    public int getProductid() {
        return productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }
}