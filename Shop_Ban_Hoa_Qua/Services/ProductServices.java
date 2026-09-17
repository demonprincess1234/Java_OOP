package Services;

import Models.Account;
import Models.Category;
import Models.Product;
import Services.Interface.IProductServcies;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductServices implements IProductServcies {

    public void PrintListProduct(ArrayList<Product> list,ArrayList<Category> categoryArrayList) {
        for(Product p : list) {
            System.out.println("ID: " + p.getId());
            for(Category c : categoryArrayList) {
                if(p.getCategoryId() == c.getId()) {
                    System.out.println("Ten danh sach: " + c.getName());
                }
            }
            System.out.println("Gia goc: " + p.getPrice());
            System.out.println("Gia khuyen mai: " + p.getDiscountPrice());
            System.out.println("Trang thai giam gia: " + p.isDiscount());
            System.out.println();
        }
    }

    public void addProduct(ArrayList<Product> products) {
        try {
            System.out.print("Nhap ten hoa qua: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            System.out.print("Gia goc: ");
            double price = Double.parseDouble(scanner.nextLine());
            if (price <= 0) {
                throw new IllegalArgumentException("Giá gốc bắt buộc phải lớn hơn 0!");
            }

            System.out.print("Gia khuyen mai: ");
            double discountPrice = Double.parseDouble(scanner.nextLine());
            if (discountPrice < 0 && discountPrice > price) {
                throw new IllegalArgumentException("Giá khuyến mãi không được là số âm!");
            }

            System.out.print("Co ap dung giam gia khong? (true/false): ");
            boolean isDiscount = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Nhập ID danh mục (1: Nội địa, 2: Nhập khẩu): ");
            int categoryId = Integer.parseInt(scanner.nextLine());

            int newId = 1;
            if (!products.isEmpty()) {
                newId = products.get(products.size() - 1).getId() + 1;
            }

            products.add(new Product(newId, name, price, discountPrice, isDiscount, categoryId));
            System.out.println("Thêm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập liệu! Vui lòng nhập đúng định dạng số.");

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void updateProduct(ArrayList<Product> products) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập ID hoa quả cần cập nhật: ");
            int id = Integer.parseInt(scanner.nextLine());
            Product found = null;
            for(Product p : products) {
                if(p.getId() == id) {
                    found = p;
                    break;
                }
            }
            if (found != null) {
                System.out.print("Nhap gia goc moi: ");
                double newprice = Double.parseDouble(scanner.nextLine());
                if(newprice < 0) {
                    throw new IllegalAccessException("Gia goc bat buoc phai lon hon 0");
                } else {
                    found.setPrice(Double.parseDouble(scanner.nextLine()));
                    System.out.print("Có giảm giá không (true/false): ");
                    boolean newDiscount = Boolean.parseBoolean(scanner.nextLine());
                    found.setDiscount(newDiscount);
                    if(newDiscount) {
                        System.out.print("Nhap gia khuyen mai moi: ");
                        double newDiscountPrice = Double.parseDouble(scanner.nextLine());
                        if(newDiscountPrice > 0 && newDiscountPrice <= newprice) {
                            found.setDiscountPrice(newDiscountPrice);
                        } else {
                            throw new IllegalAccessException("Loi nhap lieu");
                        }
                    }
                }
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Không tìm thấy sản phẩm có ID = " + id);
            }
        } catch (Exception e) {
            System.out.println("Lỗi nhập liệu!");
        }
    }

    public void removeProduct(ArrayList<Product> products) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap ID hoa qua can xoa: ");
            int id = Integer.parseInt(scanner.nextLine());

            Product found = null;
            for(Product p : products) {
                if(p.getId()==id) {
                    found = p;
                    break;
                }
            }
            if(found != null) {
                products.remove(found);
                System.out.println("Da xoa thanh cong " + found.getName());
            } else {
                System.out.println("Khong tim thay hoa qua ID= " + found.getId());
            }
        } catch (Exception e) {
            System.out.println("Loi nhap lieu");
        }
    }

    public void displayProductsForCustomer(ArrayList<Product> products) {
        System.out.println("Danh sach hoa qua dang ban");
        for(Product p: products) {
            System.out.println("ID: " + p.getId());
            System.out.println("Ten hoa qua: " + p.getName());
            if(p.isDiscount()) {
                double newPrice = p.getPrice() - p.getDiscountPrice();
                System.out.println("Gia: "+ newPrice+ "--San pham dang duoc giam gia");
            } else {
                System.out.println("Gia: " + p.getPrice()+"--San pham khong duoc giam gia");
            }
        }
    }

	@Override
	public void PrintListProduct(ArrayList<Product> list, ArrayList<Category> categories, ArrayList<Account> accounts) {
	}
}
