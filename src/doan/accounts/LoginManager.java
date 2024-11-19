package doan.accounts;

import java.io.*;

public class LoginManager {
    private Account[] adminAccounts;
    private Account[] userAccounts;
    private int adminCount;
    private int userCount;

    public LoginManager() {
        adminAccounts = new Account[10]; //  tối đa 10 tài khoản admin
        userAccounts = new Account[50]; //  tối đa 50 tài khoản user
        adminCount = 0;
        userCount = 0;
        loadAccounts("acc_admin.txt", true);
        loadAccounts("acc_users.txt", false);
    }

    private void loadAccounts(String fileName, boolean isAdmin) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    Account account = new Account(data[0], data[1]);
                    if (isAdmin) {
                        adminAccounts[adminCount++] = account;
                    } else {
                        userAccounts[userCount++] = account;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public boolean authenticate(String username, String password, boolean isAdmin) {
        Account[] accounts = isAdmin ? adminAccounts : userAccounts;
        int count = isAdmin ? adminCount : userCount;
        for (int i = 0; i < count; i++) {
            if (accounts[i].getUsername().equals(username) && accounts[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}