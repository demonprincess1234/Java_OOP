package Services;

import Models.Account;
import Services.Interface.IAccountServices;

import java.util.ArrayList;

public class AccountServices implements IAccountServices {
    public static Account handleLogin(ArrayList<Account> list,String userName,String password) {
        Account loginUser = null;
        for(Account acc: list) {
            if(acc.getUsername().contains(userName) && acc.getPassword().contains(password)) {
                loginUser = acc;
            }
        }
        return loginUser;
    }

    @Override
    public Account handleLogin2(ArrayList<Account> list, String userName, String passwor) {
        Account loginUser = null;
        for(Account acc: list) {
            if(acc.getUsername().contains(userName) && acc.getPassword().contains(passwor)) {
                loginUser = acc;
            }
        }
        return loginUser;
    }
}
