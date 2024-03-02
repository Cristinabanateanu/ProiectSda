package org.example.Service;

import org.example.Exceptions.InvalidClientException;
import org.example.Repository.ClientRepository;
import org.example.model.Client;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository();


    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void insertClient(Client client){
        if(client.getNume()==null || client.getTelefon()==null){
            throw new InvalidClientException("Client invalid, date incorecte");
        }
        clientRepository.save(client);
    }
}
