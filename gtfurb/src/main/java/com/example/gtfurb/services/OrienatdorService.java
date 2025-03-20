package com.example.gtfurb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.gtfurb.repository.OrientadorRepository;

public class OrienatdorService {

    @Autowired
    private OrientadorRepository orientadorRepository;
    @Autowired
    private BCryptPasswordEncoder bCript;

    OrienatdorService() {

    }
}
