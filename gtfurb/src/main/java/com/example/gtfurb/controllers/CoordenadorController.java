package com.example.gtfurb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gtfurb.services.CoordenadorService;

@Controller
@RequestMapping("/coordenador")
public class CoordenadorController {

    private CoordenadorService coordenadorService;
}
