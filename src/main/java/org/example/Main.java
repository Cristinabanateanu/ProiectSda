package org.example;

import org.example.Exceptions.InvalidCalculatorException;
import org.example.Repository.CalculatorRepository;
import org.example.Repository.ClientRepository;
import org.example.Repository.ReparatieRepository;
import org.example.Service.CalculatorService;
import org.example.Service.ClientService;
import org.example.Service.ReparatieService;
import org.example.model.Calculator;
import org.example.model.Client;
import org.example.model.Reparatie;

import java.util.Scanner;

public class Main {
    //    private static CalculatorRepository calculatorRepository = new CalculatorRepository();
//    private static ClientRepository clientRepository = new ClientRepository();
//    private static ReparatieRepository reparatieRepository = new ReparatieRepository();
    private static CalculatorService calculatorService = new CalculatorService();
    private static ClientService clientService = new ClientService();
    private static ReparatieService reparatieService = new ReparatieService();
    public static void main(String[] args) throws InvalidCalculatorException {
        insertDateInTabel();
    }

    private static void insertDateInTabel() throws InvalidCalculatorException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numele clientului este:");
        String clientName = scanner.nextLine();

        System.out.println("Numarul de telefon al clientului este:");
        String clientNumber = scanner.nextLine();

        Client client = new Client();
        client.setNume(clientName);
        client.setTelefon(clientNumber);

        System.out.println("Capacitatea memoriei calculatorului este: ");
        Integer cap_memorie=scanner.nextInt();
        scanner.nextLine();

        Calculator calculator = new Calculator();
        calculator.setId_client(client);
        calculator.setCapacitate_memorie(cap_memorie);

        System.out.println("Data reparatiei:");
        String localDate=scanner.nextLine();

        System.out.println("Costul reparatiei:");
        Double cost_reparatie = scanner.nextDouble();

        System.out.println("S-a reparat complet?");
        Boolean reparat = scanner.nextBoolean();

        Reparatie reparatie = new Reparatie();
        reparatie.setId_client(client);
        reparatie.setCost_reparatie(cost_reparatie);
        reparatie.setData_reparatie(localDate);
        reparatie.setReparat(reparat);


//        clientRepository.save(client);
//        calculatorRepository.save(calculator);
//        reparatieRepository.save(reparatie);
        clientService.insertClient(client);
        calculatorService.insertCalculator(calculator);
        reparatieService.insertReparatie(reparatie);
    }
}