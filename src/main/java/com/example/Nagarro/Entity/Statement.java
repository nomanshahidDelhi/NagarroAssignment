package com.example.Nagarro.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Statement {
    private Integer id;
    private Integer accountId;
    private String date;
    private String amount;
}
