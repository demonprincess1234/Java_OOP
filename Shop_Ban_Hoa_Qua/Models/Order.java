package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Order {
    private int orderId;
    private String buyerUsername;
    private int productId;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String orderDate;

    public Order(int orderId, String buyerUsername, int productId, int quantity, double unitPrice, double totalPrice) {
        this.orderId = orderId;
        this.buyerUsername = buyerUsername;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.orderDate = now.format(formatter);
    }

    public int getOrderId() { return orderId; }
    public String getBuyerUsername() { return buyerUsername; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    public double getTotalPrice() { return totalPrice; }
    public String getOrderDate() { return orderDate; }
}