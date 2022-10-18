package com.usa.reto.Repository.Crud;

import com.usa.reto.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

public interface RepositoryCrudReservation extends CrudRepository<Reservation, Integer>{



   @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();

   public List<Reservation>findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

   public List<Reservation>findAllByStatus(String status);
    
}
