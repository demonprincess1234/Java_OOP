import Models.Account;
import Models.Category;
import Models.Order;
import Models.Product;
import Services.AccountServices;
import Services.CategoryServices;
import Services.OrderServices;
import Services.ProductServices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static AccountServices accountServices=new AccountServices();
    private static ProductServices productServices=new ProductServices();
    private static OrderServices orderServices = new OrderServices();
    private static CategoryServices categoryServices = new CategoryServices();

    public static void main(String[] args) {
        initMockData();

        while (true) {
            System.out.println("========================================");
            System.out.println("   HỆ THỐNG QUẢN LÝ CỬA HÀNG HOA QUẢ");
            System.out.println("========================================");
            System.out.println("1. Đăng nhập");
            System.out.println("0. Thoát chương trình");
            System.out.println("----------------------------------------");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine();
            if(choice.equals("1")) {
                handleLogin();
            } else if(choice.equals("0")) {
                System.out.print("Thoat chuong trinh");
                break;
            } else {
                System.out.print("Loi dang nhap");
            }
        }
    }

    private static void initMockData() {
        accounts.add(new Account("admin","123",1));
        accounts.add(new Account("khachhang1","123",2));
        accounts.add(new Account("khachhang2","123",2));
        categories.add(new Category(1,"Hoa qua noi dia"));
        categories.add(new Category(2,"Hoa qua nhap khau"));
        products.add(new Product(1,"Cam sanh Ham Yen",40000,35000,true,1));
        products.add(new Product(2,"Xoai cat Hoa Loc",70000,0,false,1));
        products.add(new Product(3,"Tao Envy New Zealand", 150000,125000,true,2));
        products.add(new Product(4,"Nho den khong hat My",200000,0,false,2));
    }

    private static void handleLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        if(username == null || username.isBlank()) {
            System.out.print("Username khong duoc de trong");
            return;
        }
        System.out.print("Mat khau: ");
        String password = scanner.nextLine();
        if(password == null || password.isBlank()) {
            System.out.print("Mat khau khong duoc de trong");
            return;
        }
        var account= AccountServices.handleLogin(accounts,username,password);
        if(account==null){
            System.out.println("User naem password sai");
        }
        assert account != null;
        if(account.getRoleId()==1){
            adminMenu(account);
        }else {
            customerMenu(account);
        }
    }

    private static void adminMenu(Account loginUser) {
        System.out.println("================ MENU CHỦ CỬA HÀNG ================");
        System.out.println("Xin chao: " + loginUser.getUsername() + "Role: Chu cua hang");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Xem danh sách toàn bộ hoa quả");
        System.out.println("2. Thêm mới hoa quả");
        System.out.println("3. Cập nhật thông tin hoa quả (giá, giảm giá)");
        System.out.println("4. Xóa hoa quả");
        System.out.println("5. Xem danh sách tất cả các đơn hàng");
        System.out.println("0. Đăng xuất");
        System.out.print("Lua chon cua ban: ");
        String choice = scanner.nextLine();
        System.out.println();

        switch (choice) {
            case"1":
                productServices.PrintListProduct(products,categories);
                break;
            case "2":
                productServices.addProduct(products);
                break;
            case "3":
                productServices.updateProduct(products);
                break;
            case "4":
                productServices.removeProduct(products);
                break;
            case "5":
                orderServices.displayAllOrder(orders);
                break;
            case "0":
                return;
            default:
                System.out.println("Lua chon khong hop le");
        }
    }




    private static void customerMenu(Account loginUser) {
        System.out.println("Xin chao " + loginUser.getUsername() + "Role: Khach hang");
        System.out.println("-------------------------------------------------------");
        System.out.println("1. Xem danh sách hoa quả đang bán");
        System.out.println("2. Lọc hoa quả theo danh mục");
        System.out.println("3. Mua hoa quả (Đặt hàng)");
        System.out.println("4. Xem lịch sử đơn hàng của tôi");
        System.out.println("0. Đăng xuất");
        System.out.println("=======================================================");
        System.out.println("Lua chon cua ban: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                productServices.displayProductsForCustomer(products);
                break;
            case "2":
                categoryServices.filterByCategory(categories, products);
                break;
            case "3":
                buyProduct(loginUser.getUsername());
                break;
            case "4":
                viewOrderHistory(loginUser.getUsername());
                break;
            case "0":
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }


    private static void buyProduct(String username) {
        try {
            System.out.print("Nhap ID hoa qua muon mua: ");
            int id = Integer.parseInt(scanner.nextLine());
            Product found = null;
            for(Product p:products) {
                if(p.getId() == id) {
                    found = p;
                }
            }
            if(found == null) {
                throw new IllegalAccessException("ID hoa qua khong ton tai");
            }
            System.out.println("Nhap so luong: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if(quantity <= 0) {
                throw new IllegalAccessException("Loi so luong mua");
            }
            double totalPrice = quantity * (found.getPrice() - found.getDiscountPrice());
            double unitPrice = found.getPrice() - found.getDiscountPrice();
            int newOrderId = 1;
            if (!orders.isEmpty()) {
                newOrderId = orders.get(orders.size() - 1).getOrderId() + 1;
            }

            Order newOrder = new Order(newOrderId, username, found.getId(), quantity, unitPrice, totalPrice);
            orders.add(newOrder);

            System.out.println("--- ĐẶT HÀNG THÀNH CÔNG ---");
            System.out.println("Bạn đã mua: " + quantity + " x " + found.getName());
            System.out.println("Tổng thanh toán: " + totalPrice + " VNĐ");

        } catch (Exception e) {
            System.out.println("Loi nhap lieu");
        }
    }
    private static void viewOrderHistory(String username) {
        System.out.println("\n--- LỊCH SỬ ĐƠN HÀNG CỦA BẠN ---");
        boolean hasOrder = false;
        for (Order o : orders) {
            if (o.getBuyerUsername().equals(username)) {
               System.out.println("Ma don hang: " + o.getOrderId());
               System.out.println("Ma san pham: " +o.getProductId());
               System.out.println("So luong: "+ o.getQuantity());
               System.out.println("Tong tien: "+o.getTotalPrice());
               System.out.println("Ngay: "+ o.getOrderDate());

               hasOrder = true;
            }
        }
        if (!hasOrder) {
            System.out.println("Bạn chưa có đơn hàng nào.");
        }
    }
}