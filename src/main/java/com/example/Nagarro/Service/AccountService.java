package com.example.Nagarro.Service;

import com.example.Nagarro.Entity.Account;
import java.util.List;

public interface AccountService {

    /**
     * This function returns a list of all accounts.
     *
     * @return A list of all accounts in the database.
     */
    List<Account> getAllAccounts();


    /**
     * Get an account by id.
     *
     * @param id The id of the account to get.
     * @return Account
     */
    Account getAccount(int id);
}