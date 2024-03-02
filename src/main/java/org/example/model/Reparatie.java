package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reparatie {
    @Id
    @GeneratedValue
    Integer id_reparatie;
    Double cost_reparatie;
    String data_reparatie;
    Boolean reparat ;
    @ManyToOne
    Client id_client;

    public Integer getId_reparatie() {
        return id_reparatie;
    }

    public void setId_reparatie(Integer id_reparatie) {
        this.id_reparatie = id_reparatie;
    }

    public Double getCost_reparatie() {
        return cost_reparatie;
    }

    public void setCost_reparatie(Double cost_reparatie) {
        this.cost_reparatie = cost_reparatie;
    }

    public String getData_reparatie() {
        return data_reparatie;
    }

    public void setData_reparatie(String data_reparatie) {
        this.data_reparatie = data_reparatie;
    }

    public Boolean getReparat() {
        return reparat;
    }

    public void setReparat(Boolean reparat) {
        this.reparat = reparat;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }
}
