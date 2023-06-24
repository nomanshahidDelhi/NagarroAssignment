package com.example.Nagarro.Service;

import com.example.Nagarro.Entity.Statement;

import java.util.List;

public interface StatementService {
    /**
     * Find all statements.
     *
     * @return A list of all the statements in the database.
     */
    List<Statement> findAll();

    /**
     * It returns a list of statements that have an amount between amount1 and amount2.
     *
     * @param amount1 The lower bound of the amount range.
     * @param amount2 The upper bound of the amount.
     * @return A list of statements that have an amount between the two amounts given.
     */
    List<Statement> getAmountBetween(String amount1, String amount2);

    /**
     * This function returns a list of all the statements between the two dates
     *
     * @param fromDate The date from which you want to get the data.
     * @param toDate The date to which you want to get the data.
     * @return A list of statements.
     */
    List<Statement> getDateBetween(String fromDate, String toDate);
}
