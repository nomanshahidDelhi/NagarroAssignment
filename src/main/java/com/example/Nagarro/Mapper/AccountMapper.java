package com.example.Nagarro.Mapper;

import com.example.Nagarro.Entity.Account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface AccountMapper {
    /**
     * Get all accounts from the database.
     *
     * @return A list of all the accounts in the database.
     */
    @Select("SELECT * FROM account")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "accountNumber", column = "account_number"),
            @Result(property = "accountType", column = "account_type")
    })
    List<Account> getAllAccounts();

    /**
     * Get the account with the given id.
     *
     * @param id The id of the account to retrieve
     * @return An Account object
     */
    @Select("SELECT * FROM account WHERE ID = #{id}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "accountNumber", column = "account_number"),
            @Result(property = "accountType", column = "account_type")
    })
    Account getAccount(@PathParam("id") final Integer id);
}
