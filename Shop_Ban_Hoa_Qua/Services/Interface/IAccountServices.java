package Services.Interface;

import Models.Account;

import java.util.ArrayList;

public interface IAccountServices {
    Account handleLogin2(ArrayList<Account> list, String userName, String passwor);
}
