package com.example.teamsep.guestHouse.servicesImpl;

import com.example.teamsep.guestHouse.models.ReservationModel;
import com.example.teamsep.guestHouse.models.RoomModel;
import com.example.teamsep.guestHouse.models.User;
import com.example.teamsep.guestHouse.repositories.ReservationRepository;
import com.example.teamsep.guestHouse.repositories.UserRepository;
import com.example.teamsep.guestHouse.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class ReservationServiceImpl implements ReservationService {
	
    @Autowired
    private ReservationRepository reservationRepository;
   
    @Autowired
	private UserRepository userRepository;


    @Override
    public List<ReservationModel> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<ReservationModel> getReservationsByUserId(Long userId) {
        return reservationRepository.findAllByUserId(userId);
    }

    @Override
    public ReservationModel getReservationById(Long id) {
        Optional<ReservationModel> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

  
    	
    @Override
    public ReservationModel addReservation(ReservationModel reservation) {
        // Assuming you already have the RoomModel object in your reservation
        RoomModel room = reservation.getRoom();
        if (room == null) {
            // Handle the case where the room is not provided
            // You might want to return an error response or log the issue
            throw new RuntimeException("Room not provided in the reservation");
        }

        // Assuming you can access the user's ID directly from the reservation
        Long userId = reservation.getUser().getId();

        // Fetch the user from the database based on the user ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        // Set the user for the reservation
        reservation.setUser(user);

        // Set the room for the reservation
        reservation.setRoom(room);

        // Save the reservation to the database
        return reservationRepository.save(reservation);
    }


    @Override
    public ReservationModel editReservation(ReservationModel reservation) {
        return reservationRepository.save(reservation);
    }

	@Override
	public void deleteReservationById(Long id) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(id);

	}


}
