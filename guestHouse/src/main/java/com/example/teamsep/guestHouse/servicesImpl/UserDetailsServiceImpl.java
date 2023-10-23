package com.example.teamsep.guestHouse.servicesImpl;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.teamsep.guestHouse.models.User;
import com.example.teamsep.guestHouse.models.UserDetailsImpl;
import com.example.teamsep.guestHouse.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
		return UserDetailsImpl.build(user);
	}

	
	public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + id));

	    // You need to create a UserDetails object based on the retrieved user
	    UserDetails userDetails = UserDetailsImpl.build(user);

	    return userDetails;
	}
	
	public List<User> getAllUsers(){
	return userRepository.findAll();
}
	
    public void deleteUserById(Long id) {
     userRepository.deleteById(id); 
}
}