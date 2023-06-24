package com.example.Nagarro.Mapper;

import com.example.Nagarro.Entity.Statement;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface StatementMapper {
    /**
     * Find all statements.
     *
     * @return A list of all the statements in the database.
     */
    @Select("SELECT * FROM statement")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "accountId", column = "account_id"),
            @Result(property = "date", column = "datefield")
    })
    List<Statement> findAll();

    /**
     * This function returns a list of statements between two dates
     *
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return A list of Statement objects.
     */
    @Select("SELECT * from statement where datefield BETWEEN #{startDate} AND #{endDate}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "accountId", column = "account_id"),
            @Result(property = "date", column = "datefield")
    })
    List<Statement> getDateBetween(@PathParam("startDate") final BigDecimal startDate, @PathParam("endDate") final BigDecimal endDate);

    /**
     * This function returns a list of statements with amounts between the two amounts specified in the function
     *
     * @param fromAmount The lower bound of the range.
     * @param toAmount The upper bound of the amount range.
     * @return A list of statements with amounts between the two amounts.
     */
    @Select("SELECT * from statement where amount BETWEEN #{fromAmount} AND #{toAmount} Order by amount ASC")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "accountId", column = "account_id"),
            @Result(property = "date", column = "datefield")
    })
    List<Statement> getAmountBetween(@PathParam("fromAmount") final BigDecimal fromAmount, @PathParam("toAmount") final BigDecimal toAmount);
}
