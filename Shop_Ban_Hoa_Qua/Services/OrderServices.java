package Services;

import Models.Order;

import Services.Interface.IOrderServices;

import java.util.ArrayList;

public class OrderServices implements IOrderServices {
    @Override
    public void displayAllOrder(ArrayList<Order> orders) {
        System.out.println("\n--- TẤT CẢ ĐƠN HÀNG ---");
        for (Order o : orders) {
            System.out.print("Ma DH: " + o.getOrderId());
            System.out.print("Khach: " + o.getBuyerUsername());
            System.out.print("Ma SP: " + o.getProductId());
            System.out.print("SL: " + o.getQuantity());
            System.out.print("Don gia: " + o.getUnitPrice());
            System.out.print("Tong: " + o.getTotalPrice());
            System.out.print("Ngay: " + o.getOrderDate());
        }
    }

}
