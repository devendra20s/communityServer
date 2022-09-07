package com.communityServer.service;
//import com.communityServer.model.User;
import com.communityServer.model.UserModel;
import com.communityServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("email Not found" + email);
        }
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}