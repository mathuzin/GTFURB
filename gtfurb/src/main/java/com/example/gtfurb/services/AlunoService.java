package com.example.gtfurb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gtfurb.repository.AlunoRepository;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private RelatorioRepository relatorioRepository;
    @Autowired
    private BCryptPasswordEncoder bCript;

    AlunoService() {

    }

}
