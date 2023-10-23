package com.example.teamsep.guestHouse.services;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.teamsep.guestHouse.models.User;



public interface UserDetailsService {
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
    UserDetails loadUserById(Long id) throws UsernameNotFoundException;
    public List<User> getAllUsers();
    public void deleteUserById(Long id);




}

