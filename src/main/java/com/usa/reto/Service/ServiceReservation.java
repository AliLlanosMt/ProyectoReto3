package com.usa.reto.Service;

import com.usa.reto.Model.Reservation;
import com.usa.reto.Model.reporte.CountClient;
import com.usa.reto.Model.reporte.StatusAcount;
import com.usa.reto.Repository.RepositoryReservation;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceReservation {

    @Autowired
    private RepositoryReservation repository;

    public List<Reservation> getAll() {
        return repository.getAll();
    }

    public Optional<Reservation> getClient(int id) {
        return repository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return repository.save(r);
        } else {
            Optional<Reservation> rAux = repository.getReservation(r.getIdReservation());
            if (rAux.isEmpty()) {
                return repository.save(r);
            } else {
                return r;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>rAux= repository.getReservation(reservation.getIdReservation());
            if(!rAux.isEmpty()){
                if(reservation.getStartDate() !=null){
                    rAux.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    rAux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus() != null){
                    rAux.get().setStatus(reservation.getStatus());
                }
                repository.save(rAux.get());
                return rAux.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean delete(int reservationId){
        Boolean resultado = getClient(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return resultado;
    }
    public List<CountClient>getTopClients(){
        return repository.getTopClients();
    }

    public StatusAcount getStatusReport(){
        List<Reservation>completed = repository.getReservationByStatus("completed");
        List<Reservation>cancelled = repository.getReservationByStatus("cancelled");
        StatusAcount statusAcount = new StatusAcount(completed.size(), cancelled.size());
        return statusAcount;
    }


    public List<Reservation>getReservationPeriod(String dateOne, String dateTwo){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateOne);
            b = parser.parse(dateTwo);
        } catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return repository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }
}