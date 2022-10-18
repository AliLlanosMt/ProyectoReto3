package com.usa.reto.Controller;

import com.usa.reto.Model.Client;
import com.usa.reto.Model.Reservation;
import com.usa.reto.Model.reporte.CountClient;
import com.usa.reto.Model.reporte.StatusAcount;
import com.usa.reto.Service.ServiceReservation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerReservation {

    @Autowired
    private ServiceReservation service;

    @GetMapping("/all")
    public List<Reservation> getReservation() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return service.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Reservation reservation) {
        service.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return service.delete(reservationId);
    }

    @GetMapping("/report-status")
    public StatusAcount getReservationStatus() {
        return service.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return service.getTopClients();
    }


    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getByDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return service.getReservationPeriod(dateOne, dateTwo);
    }
}
