package com.usa.reto.Service;

import com.usa.reto.Model.Client;
import com.usa.reto.Repository.RepositoryClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClient {

    @Autowired
    private RepositoryClient repository;

    public List<Client> getAll() {
        return repository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return repository.getClient(id);
    }

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return repository.save(c);
        } else {
            Optional<Client> cAux = repository.getClient(c.getIdClient());
            if (cAux.isEmpty()) {
                return repository.save(c);
            } else {
                return c;
            }
        }
    }
    public Client update(Client client){
        if(client.getIdClient() != null){
            Optional<Client>cAux =getClient(client.getIdClient());
            if(!cAux.isEmpty()){
                if(client.getName() != null){
                    cAux.get().setName(client.getName());
                }
                if(client.getAge() != null){
                    cAux.get().setAge(client.getAge());
                }
                if(client.getPassword() != null){
                    cAux.get().setPassword(client.getPassword());
                }
                repository.save(cAux.get());
                return client;
            }else{
                return client;
            }
        }else{
            return client;
        }

    }

    public boolean delete(int clientId){
        Boolean resultado = getClient(clientId).map(client ->{
            repository.delete(client);
            return true;
        }).orElse(false);

        return resultado;
    }
}