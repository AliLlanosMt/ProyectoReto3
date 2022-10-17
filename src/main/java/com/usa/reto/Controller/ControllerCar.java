package com.usa.reto.Controller;

import com.usa.reto.Model.Car;
import com.usa.reto.Service.ServiceCar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ControllerCar {

    @Autowired
    private ServiceCar service;

    @GetMapping("/all")
    public List<Car> getCar() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int id){
        return service.getCar(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Car car) {
        service.save(car);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car update(@RequestBody Car car){
        return service.update(car);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int carId){
        return service.delete(carId);
    }

}
