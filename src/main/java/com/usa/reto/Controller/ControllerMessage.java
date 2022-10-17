package com.usa.reto.Controller;

import com.usa.reto.Model.Client;
import com.usa.reto.Model.Message;
import com.usa.reto.Service.ServiceMessage;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerMessage {
    
    @Autowired
    private ServiceMessage service;
    
    @GetMapping("/all")
    public List<Message> getMessage(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getMassage(@PathVariable("id") int id){
        return service.getMessage(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Message message) {
        service.save(message);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return service.update(message);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int messageId){
        return service.delete(messageId);
    }
}
