package com.usa.reto.Service;

import com.usa.reto.Model.Car;
import com.usa.reto.Repository.RepositoryCar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCar {

    @Autowired
    private RepositoryCar repository;

    public List<Car> getAll() {
        return repository.getAll();
    }

    public Optional<Car> getCar(int id) {
        return repository.getCar(id);
    }

    public Car save(Car c) {
        if (c.getIdCar() == null) {
            return repository.save(c);
        } else {
            Optional<Car> cAux = repository.getCar(c.getIdCar());
            if (cAux.isEmpty()) {
                return repository.save(c);
            } else {
                return c;
            }
        }
    }
    public Car update(Car car){
        if(car.getIdCar() != null){
            Optional<Car>cAux = repository.getCar(car.getIdCar());
            if(!cAux.isEmpty()){
                if(car.getName() != null){
                    cAux.get().setName(car.getName());
                }
                if(car.getBrand() != null){
                    cAux.get().setBrand(car.getBrand());
                }
                if(car.getYear() != null){
                    cAux.get().setYear(car.getYear());
                }
                if(car.getDescription() != null){
                    cAux.get().setDescription(car.getDescription());
                }
                if(car.getGama() != null){
                    cAux.get().setGama(car.getGama());
                }
                repository.save(cAux.get());
                return cAux.get();
            }else{
                return car;
            }
        }else{
            return car;
        }
    }

    public boolean delete(int carId){
        Boolean resultado = getCar(carId).map(car ->{
            repository.delete(car);
            return true;
        }).orElse(false);

        return resultado;
    }
}