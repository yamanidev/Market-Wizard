package model;

public class Product {

    int id;
    String name;
    double purchasedPrice;
    double soldPrice;
    double total = 0;
    String expirationDate;
    String category;
    int quantity;

    public Product(int id, String name, double soldPrice, String category, int quantity, double total) {
        this.id = id;
        this.name = name;
        this.soldPrice = soldPrice;
        this.total = total;
        this.category = category;
        this.quantity = quantity;
    }

    public Product(int id, String name, double soldPrice, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.soldPrice = soldPrice;
        this.category = category;
        this.quantity = quantity;
    }

    public Product(int id, String name, double purchasedPrice,
                   double soldPrice, String expirationDate,
                   String category, int quantity, double total) {
        this.id = id;
        this.name = name;
        this.purchasedPrice = purchasedPrice;
        this.soldPrice = soldPrice;
        this.expirationDate = expirationDate;
        this.category = category;
        this.quantity = quantity;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
