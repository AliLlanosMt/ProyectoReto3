package com.usa.reto.Controller;

import com.usa.reto.Model.Admin;
import com.usa.reto.Model.Client;
import com.usa.reto.Service.ServiceAdmin;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerAdmin {
    
    @Autowired
    private ServiceAdmin service;
    
    @GetMapping("/all")
    public List<Admin> getAdmin(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admin>getAdmin(@PathVariable("id")int id){
        return service.getAdmin(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Admin admin) {
        service.save(admin);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return service.update(admin);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int adminId){
        return service.delete(adminId);
    }
}