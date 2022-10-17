package com.usa.reto.Controller;

import com.usa.reto.Model.Client;
import com.usa.reto.Model.Gama;
import com.usa.reto.Service.ServiceGama;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ControllerGama {

    @Autowired
    private ServiceGama service;

    @GetMapping("/all")
    public List<Gama> getGama() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable("id") int id){
        return service.getIdGama(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Gama gama) {
        service.save(gama);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama gama){
        return service.update(gama);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int gamaId){
        return service.delete(gamaId);
    }
}
