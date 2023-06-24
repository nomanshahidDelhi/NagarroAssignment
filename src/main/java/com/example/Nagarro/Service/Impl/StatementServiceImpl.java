package com.example.Nagarro.Service.Impl;

import com.example.Nagarro.Config.TextToDecimal;

import com.example.Nagarro.Entity.Statement;
import com.example.Nagarro.Mapper.StatementMapper;
import com.example.Nagarro.Service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementMapper statementMapper;

    @Override
    public List<Statement> findAll() {
        return statementMapper.findAll();
    }

    @Override
    public List<Statement> getAmountBetween(String amount1, String amount2) {
        BigDecimal amount1BigDecimal = TextToDecimal.toBigDecimal(amount1);
        BigDecimal amount2BigDecimal = TextToDecimal.toBigDecimal(amount2);
        return statementMapper.getAmountBetween(amount1BigDecimal, amount2BigDecimal);
    }

    @Override
    public List<Statement> getDateBetween(String fromDate, String toDate) {
        BigDecimal dec1 = TextToDecimal.toBigDecimal(fromDate);
        BigDecimal dec2 = TextToDecimal.toBigDecimal(toDate);
        return statementMapper.getDateBetween(dec1, dec2);
    }

}
