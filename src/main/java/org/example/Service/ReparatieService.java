package org.example.Service;

import org.example.Exceptions.InvalidReparatieException;
import org.example.Repository.ReparatieRepository;
import org.example.model.Reparatie;

public class ReparatieService {
    public ReparatieRepository reparatieRepository=new ReparatieRepository();


    public ReparatieRepository getReparatieRepository() {
        return reparatieRepository;
    }

    public void setReparatieRepository(ReparatieRepository reparatieRepository) {
        this.reparatieRepository = reparatieRepository;
    }

    public void insertReparatie(Reparatie reparatie){
        if(reparatie.getData_reparatie()==null || reparatie.getCost_reparatie()==null ||reparatie.getCost_reparatie()<0){
            throw new InvalidReparatieException("Reparatie Invalida");
        }
        reparatieRepository.save(reparatie);
    }
}
