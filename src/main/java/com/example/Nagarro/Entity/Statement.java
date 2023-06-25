package com.example.Nagarro.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Statement {
    private Integer id;
    private Integer accountId;
    private String date;
    private String amount;
    @JsonIgnore
    private int dd;
    @JsonIgnore
    private int mm;
    @JsonIgnore
    private int yyyy;
}
