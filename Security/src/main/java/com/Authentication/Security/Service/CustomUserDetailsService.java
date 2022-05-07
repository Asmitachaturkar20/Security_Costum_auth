package com.Authentication.Security.Service;

import com.Authentication.Security.Model.CustomUserDetail;
import com.Authentication.Security.Model.User;
import com.Authentication.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUsername(name);
        optionalUser.orElseThrow(()-> new UsernameNotFoundException("nahi mila user.."));
        return optionalUser.map(CustomUserDetail::new).get();
    }
}
