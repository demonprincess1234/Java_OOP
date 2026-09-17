package Services.Interface;

import Models.Category;
import Models.Product;

import java.util.ArrayList;
import java.util.Calendar;

public interface ICategory {
    void filterByCategory(ArrayList<Category> categories, ArrayList<Product> products);
}
