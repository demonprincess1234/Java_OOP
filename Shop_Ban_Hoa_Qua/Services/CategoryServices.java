package Services;

import Models.Category;
import Models.Product;
import Services.Interface.ICategory;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryServices implements ICategory {
    @Override

    public void filterByCategory(ArrayList<Category> categories, ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loc hoa qua theo hang muc:");
        for(Category c: categories) {
            System.out.println(c.getId()+" "+ c.getName());
        }
        System.out.println("Lua chon cua ban: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product p: products) {
            if(p.getCategoryId() == id) {
                System.out.println("ID: "+p.getId());
                System.out.println("Ten san pham: "+p.getName());
                System.out.println("Gia: "+p.getPrice());
                System.out.println("Giam gia: "+p.getDiscountPrice());
                System.out.println();
            }
        }
    }
}
