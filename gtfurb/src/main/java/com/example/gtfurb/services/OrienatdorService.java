package com.example.gtfurb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gtfurb.repository.OrientadorRepository;

@Service
public class OrienatdorService {

    @Autowired
    private OrientadorRepository orientadorRepository;
    @Autowired
    private BCryptPasswordEncoder bCript;

    OrienatdorService() {

    }
}
