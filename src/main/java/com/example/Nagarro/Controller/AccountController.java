package com.example.Nagarro.Controller;

import com.example.Nagarro.Entity.Account;
import com.example.Nagarro.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    // Injecting the AccountService class into the AccountController class.
    @Autowired
    private AccountService accountService;

    
    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    /**
     * The function takes an id as a path variable, and returns an account object
     *
     * @param id The id of the account to retrieve.
     * @return Account
     */
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id){
        return accountService.getAccount(id);
    }
}
