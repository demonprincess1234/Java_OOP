package Models;

public class Product {
    private int id;
    private String name;
    private double price;
    private double discountPrice;
    private boolean isDiscount;
    private int categoryId;

    public Product(int id, String name, double price, double discountPrice, boolean isDiscount, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.isDiscount = isDiscount;
        this.categoryId = categoryId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getDiscountPrice() { return discountPrice; }
    public void setDiscountPrice(double discountPrice) { this.discountPrice = discountPrice; }
    public boolean isDiscount() { return isDiscount; }
    public void setDiscount(boolean discount) { isDiscount = discount; }
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
}