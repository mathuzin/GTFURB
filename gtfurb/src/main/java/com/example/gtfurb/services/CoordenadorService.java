package com.example.gtfurb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gtfurb.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
    
    @Autowired
    private CoordenadorRepository coordenadRepository;
    @Autowired
    private BCryptPasswordEncoder bCript;

    CoordenadorService() {

    }
}
