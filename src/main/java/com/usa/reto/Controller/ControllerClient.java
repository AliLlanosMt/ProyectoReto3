package com.usa.reto.Controller;

import com.usa.reto.Model.Client;
import com.usa.reto.Service.ServiceClient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerClient {
    
    @Autowired
    private ServiceClient service;
    
    @GetMapping("/all")
    public List<Client> getClients(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client>getClient(@PathVariable("id") int id){
        return service.getClient(id);
    }

    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Client client) {
        service.save(client);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return service.update(client);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int clientId){
        return service.delete(clientId);
    }


}
