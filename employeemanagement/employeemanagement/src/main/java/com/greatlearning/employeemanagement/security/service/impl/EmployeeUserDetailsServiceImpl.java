package com.greatlearning.employeemanagement.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.security.entity.User;
import com.greatlearning.employeemanagement.security.entity.EmployeeUserDetails;
import com.greatlearning.employeemanagement.security.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeUserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("Loading user by username: {}", username);
        
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            logger.error("User not found: {}", username);
            throw new UsernameNotFoundException("Could not find user");
        }

        logger.info("User found: {}", username);
        return new EmployeeUserDetails(user);
    }
}
