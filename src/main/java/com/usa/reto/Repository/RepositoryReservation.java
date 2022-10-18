package com.usa.reto.Repository;

import com.usa.reto.Model.Client;
import com.usa.reto.Model.Reservation;
import com.usa.reto.Model.reporte.CountClient;
import com.usa.reto.Repository.Crud.RepositoryCrudReservation;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryReservation {
    
    @Autowired
    private RepositoryCrudReservation repository;

    public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return repository.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        repository.delete(reservation);
    }


    public List<Reservation>getReservationByStatus(String status){
        return repository.findAllByStatus(status);
    }

    public List<Reservation>getReservationPeriod(Date dateOne, Date dateTwo){
        return repository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    public List<CountClient>getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte =repository.countTotalReservationByClient();
        for(int i = 0; i < reporte.size(); i++){
            Client cliente =(Client) reporte.get(i)[0];
            Integer cantidad = Integer.parseInt(reporte.get(i)[1].toString());
            CountClient cc= new CountClient(cantidad,cliente);
            respuesta.add(cc);
        }
        return respuesta;
    }
}