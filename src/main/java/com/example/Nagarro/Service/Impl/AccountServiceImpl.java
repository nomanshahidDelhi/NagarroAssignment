package com.example.Nagarro.Service.Impl;

import com.example.Nagarro.Entity.Account;
import com.example.Nagarro.Exception.ResourceNotFoundException;
import com.example.Nagarro.Mapper.AccountMapper;
import com.example.Nagarro.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAllAccounts() {
        return accountMapper.getAllAccounts();
    }

    @Override
    public Account getAccount(int id) {
        return Optional.ofNullable(accountMapper.getAccount(id)).orElseThrow(()
                -> new ResourceNotFoundException(
                "NO ACCOUNT PRESENT WITH ID = " + id));
    }
}