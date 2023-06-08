package com.cglia.student.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cglia.student.dto.StudentDTO;
import com.cglia.student.repository.StudentRepository;


@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	StudentDTO userInfo = repository.findByUserName(userName);
     return new org.springframework.security.core.userdetails.User(userInfo.getUserName(), userInfo.getPassword(), new ArrayList<>());

    }
}