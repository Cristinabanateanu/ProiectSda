package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Calculator {
    //id_calculator,procesor,model,capacitate memorie,id_client
    @Id
    @GeneratedValue
    Integer id_calculator;

    public enum procesor{
        INTEL,
        AMD
    }



    private procesor procesor;
    Integer capacitate_memorie;
    @ManyToOne
    Client id_client;

    public Calculator.procesor getProcesor() {
        return procesor;
    }

    public void setProcesor(Calculator.procesor procesor) {
        this.procesor = procesor;
    }

    public Integer getId_calculator() {
        return id_calculator;
    }

    public void setId_calculator(Integer id_calculator) {
        this.id_calculator = id_calculator;
    }

    public Integer getCapacitate_memorie() {
        return capacitate_memorie;
    }

    public void setCapacitate_memorie(Integer capacitate_memorie) {
        this.capacitate_memorie = capacitate_memorie;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

}
