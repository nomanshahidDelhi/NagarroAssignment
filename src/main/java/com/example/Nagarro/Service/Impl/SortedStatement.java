package com.example.Nagarro.Service.Impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class SortedStatement {
	private Integer id;
    private Integer accountId;
    private String amount;
    private String date;
    private String dd;
    private String mm;
    private String yyyy;
}
