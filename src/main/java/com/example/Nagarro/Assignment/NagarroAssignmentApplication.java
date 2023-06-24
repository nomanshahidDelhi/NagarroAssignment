package com.example.Nagarro.Assignment;


import org.apache.ibatis.type.MappedTypes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.Nagarro.Entity.Account;
import com.example.Nagarro.Entity.Statement;


@MappedTypes({Account.class, Statement.class})
@MapperScan("com.example.Nagarro.Mapper")
@ComponentScan("com.example.Nagarro")
@SpringBootApplication
public class NagarroAssignmentApplication{

    public static void main(String[] args) {
        SpringApplication.run(NagarroAssignmentApplication.class, args);
    }

}