package com.example.tradehub.entity;

public class Product {

    private int id;
    private String name;
    private float price;
    private String account;
    private int pclass;

    private String photopath;

    public Product() {

    }


    public Product(int id, String name, String account,int pclass,float price,String photopath) {
        this.id=id;
        this.name=name;
        this.account=account;
        this.pclass=pclass;
        this.price=price;
        this.photopath=photopath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        this.pclass = pclass;
    }


    public String getPhoto() {
        return photopath;
    }

    public void setPhoto(String photopath) {
        this.photopath = photopath;
    }
}