package com.example.demo4;

public class OrderList {
    Integer Order_id;
    String Prod_name;
    String Manufacturer;
    Integer Price;

    public OrderList(Integer order_id, String prod_name, Integer price , String manufacturer) {
        this.Order_id = order_id;
        this.Prod_name = prod_name;
        this.Manufacturer = manufacturer;
        this.Price = price;
    }

    public void setOrder(Integer Order) {
        Order = Order_id;
    }

    public void setQuantity(String prod_name) {
        Prod_name = prod_name;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getOder() {
        return Order_id;
    }

    public String getQuantity() {
        return Prod_name;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public Integer getPrice() {
        return Price;
    }
}
