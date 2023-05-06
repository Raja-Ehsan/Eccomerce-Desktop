package com.example.demo4;

public class AdminProducts {
    Integer Order_id;
    Integer Customer_id;
    String Name;
    Integer Product_id;
    String PName;
    String Price;
    Integer Category_id;
    Integer Manufacturer_id;
    String Status;

    public AdminProducts(Integer Order_id, Integer Customer_id, String Name, Integer Product_id, String PName, String Price, Integer Category_id, Integer Manufacturer_id, String status){
        this.Order_id=Order_id;
        this.Customer_id=Customer_id;
        this.Name=Name;
        this.Product_id=Product_id;
        this.PName=PName;
        this.Price=Price;
        this.Category_id=Category_id;
        this.Manufacturer_id=Manufacturer_id;
        this.Status=status;
    }

    public Integer getOrder_id() {
        return Order_id;
    }

    public Integer getCustomer_id() {
        return Customer_id;
    }

    public String getName() {
        return Name;
    }

    public Integer getProduct_id() {
        return Product_id;
    }

    public String getPName() {
        return PName;
    }

    public String getPrice() {
        return Price;
    }

    public Integer getCategory_id() {
        return Category_id;
    }

    public Integer getManufacturer_id() {
        return Manufacturer_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }

    public void setCustomer_id(Integer customer_id) {
        Customer_id = customer_id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setProduct_id(Integer product_id) {
        Product_id = product_id;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setCategory_id(Integer category_id) {
        Category_id = category_id;
    }

    public void setManufacturer_id(Integer manufacturer_id) {
        Manufacturer_id = manufacturer_id;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
