package org.example.Service;

import org.example.Exceptions.InvalidCalculatorException;
import org.example.Repository.CalculatorRepository;
import org.example.model.Calculator;

public class CalculatorService {
    private CalculatorRepository calculatorRepository = new CalculatorRepository();


    public CalculatorRepository getCalculatorRepository() {
        return calculatorRepository;
    }

    public void setCalculatorRepository(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public void insertCalculator(Calculator calculator) throws InvalidCalculatorException {
        if(calculator.getCapacitate_memorie()==null || calculator.getCapacitate_memorie()<0){
            throw new InvalidCalculatorException("Invalid PC");
        }
        calculatorRepository.save(calculator);
    }
}
