package com.example.demo1.Services;

import com.example.demo1.Entities.User;
import com.example.demo1.Repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    SampleRepository sampleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return sampleRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }

}


