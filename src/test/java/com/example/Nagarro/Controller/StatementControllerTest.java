package com.example.Nagarro.Controller;

import com.example.Nagarro.Entity.Statement;
import com.example.Nagarro.Service.Impl.StatementServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class StatementControllerTest {
    @Mock
    StatementServiceImpl statementService;
    @InjectMocks
    StatementController statementController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(statementService.findAll()).thenReturn(List.of(new Statement(89, 1, "19.11.2012", "10.4978134308631", 01, 01, 2000)));

        List<Statement> result = statementController.getAll();
        Assertions.assertEquals(List.of(new Statement(89, 1, "19.11.2012", "10.4978134308631", 01, 01, 2000)), result);
    }

    @Test
    void testGetData_between() {
        when(statementService.getDateBetween(anyString(), anyString())).thenReturn(List.of(new Statement(89, 1, "19.11.2012", "10.4978134308631", 01, 01, 2000)));

        List<Statement> result = statementController.getDateBetween("fromDate", "toDate");
        Assertions.assertEquals(List.of(new Statement(1, 3, "09.08.2020", "535.197875027054", 0, 0, 0)), result);
    }

    @Test
    void testGetAmount_between() {
        when(statementService.getAmountBetween(anyString(), anyString())).thenReturn(List.of(new Statement(89, 1, "19.11.2012", "10.4978134308631", 01, 01, 2000)));

        List<Statement> result = statementController.getAmountBetween("amount1", "amount2");
        Assertions.assertEquals(List.of(new Statement(1, 3, "09.08.2020", "535.197875027054", 0, 0, 0)), result);
    }
}

