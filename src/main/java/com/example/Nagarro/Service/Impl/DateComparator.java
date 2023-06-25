package com.example.Nagarro.Service.Impl;

import java.util.Comparator;

import com.example.Nagarro.Entity.Statement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


class DateComparator implements Comparator<Statement>{
    
	@Override
    public int compare(Statement o1, Statement o2){
        if(o1.getYyyy()==o2.getYyyy()){
        	if(o1.getMm()==o2.getMm()) {
        		if(o1.getDd()>o2.getDd()) {
        			return -1;
        		} else if(o1.getDd()<o2.getDd()) {
        			return 1;
        		} else if(o1.getDd()==o2.getDd()) {
        			return 0;
        		}
        	} else if(o1.getMm()>o2.getMm()) {
        		return -1;
        	} else if(o1.getMm()>o2.getMm()) {
        		return 1;
        	}
        }
        else if(o1.getYyyy()>o2.getYyyy()){
            return -1;
        } else if(o1.getYyyy()<o2.getYyyy()){
            return 1;
        }
        
        return 0;
    }
}
