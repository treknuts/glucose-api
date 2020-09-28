package com.treknuts.glucoseapi.services;

import com.treknuts.glucoseapi.models.MyUserDetails;
import com.treknuts.glucoseapi.models.User;
import com.treknuts.glucoseapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find " + username + ".");
        }
        return new MyUserDetails(user);
    }
}
