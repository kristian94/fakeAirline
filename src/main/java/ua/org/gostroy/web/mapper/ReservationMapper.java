package ua.org.gostroy.web.mapper;

import org.springframework.stereotype.Service;
import ua.org.gostroy.domain.entity.Flight;
import ua.org.gostroy.domain.entity.Reservation;
import ua.org.gostroy.web.domain.dto.save.ReservationRequest;
import ua.org.gostroy.web.domain.dto.view.ReservationResponse;
import ua.org.gostroy.exception.NoneAvilableTickets;

import java.text.SimpleDateFormat;

/**
 * Created by Sergey on 4/23/2016.
 */
@Service
public class ReservationMapper {

    private String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public ReservationResponse toDto(Flight flight, ReservationRequest reservationRequest) throws NoneAvilableTickets {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setFlightNumber(flight.getFlightNumber().toString());
        reservationResponse.setOrigin(flight.getOrigin().airportName + "(" + flight.getOrigin().iataCode + ")");
        reservationResponse.setDestination(flight.getDestination().airportName + "(" + flight.getDestination().iataCode + ")");
        reservationResponse.setFlightTime(flight.getTraveltime());
        reservationResponse.setNumberOfSeats(reservationRequest.getNumberOfSeats());
        reservationResponse.setReserveeName(reservationRequest.getReserveeName());
        reservationResponse.setPassengers(reservationRequest.getPassengers());
        

        SimpleDateFormat parserSDF = new SimpleDateFormat(dateFormat);
        reservationResponse.setDate(parserSDF.format(flight.getDate()));

        return reservationResponse;
    }

    public Reservation fromDto(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();

        reservation.setReserveeName(reservationRequest.getReserveeName());
        reservation.setReserveePhone(reservationRequest.getReserveePhone());
        reservation.setReserveeEmail(reservationRequest.getReserveeEmail());
        reservation.setReserveeEmail(reservationRequest.getReserveeEmail());
        reservation.setPassengers(reservationRequest.getPassengers());

        return reservation;
    }
}
