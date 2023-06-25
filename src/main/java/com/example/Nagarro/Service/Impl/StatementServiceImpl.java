package com.example.Nagarro.Service.Impl;

import com.example.Nagarro.Config.TextToDecimal;



import com.example.Nagarro.Entity.Statement;
import com.example.Nagarro.Mapper.StatementMapper;
import com.example.Nagarro.Service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.time.YearMonth;


@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementMapper statementMapper;

    @Override
    public List<Statement> findAll() {
    	List<Statement> list = statementMapper.findAll();
    	List<Statement> statementList = new ArrayList<>();
    	DateComparator dateComparator = new DateComparator();
    	int currentYear = YearMonth.now().getYear();
    	int month = YearMonth.now().getMonthValue();//Current month to find last 3 Months statement
    	for(int i=0; i<list.size(); i++) {
    		Statement statementEntry = list.get(i);
    		String stringDate = statementEntry.getDate();
    		String[] transactionDate = stringDate.split("\\.");   		
    		int dd = Integer.parseInt(transactionDate[0]);
    		int mm = Integer.parseInt(transactionDate[1]);
    		int yyyy = Integer.parseInt(transactionDate[2]);
    		statementEntry.setDd(dd);
    		statementEntry.setMm(mm);
    		statementEntry.setYyyy(yyyy);
    		statementList.add(statementEntry);
    	}    	
    	Collections.sort(statementList, dateComparator);    	
    	
    	List<Statement> lastFourYearsStatement = statementList
    			.stream()
    			.filter(e->e.getYyyy()>(currentYear-4))
    			.collect(Collectors.toList ());
    	
    	return lastFourYearsStatement;
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
