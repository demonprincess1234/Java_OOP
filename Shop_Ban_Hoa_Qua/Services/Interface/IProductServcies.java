package Services.Interface;

import Models.Account;
import Models.Category;
import Models.Product;

import java.util.ArrayList;

public interface IProductServcies {
    void PrintListProduct(ArrayList<Product> list, ArrayList<Category> categories, ArrayList<Account>accounts);

}
