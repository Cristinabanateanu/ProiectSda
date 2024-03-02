package org.example.Repository;

import org.example.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRepositoryTest {
    CalculatorRepository calculatorRepository;

    @BeforeEach
    void setUp() {
        calculatorRepository = new CalculatorRepository();
    }

    @Test
    void save() {
        Calculator calculator=new Calculator();
        calculator.setCapacitate_memorie(512);
        calculator.setProcesor(Calculator.procesor.INTEL);
        calculatorRepository.save(calculator);
        Optional<Calculator> calculator1=calculatorRepository.findByCapacitateMemorie(512);
        assertTrue(calculator1.isPresent());
        assertEquals(calculator.getProcesor(),calculator1.get().getProcesor());
    }

    @Test
    void findByCapacitateMemorie() {
    }
}