package com.example.gtfurb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gtfurb.services.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;
}
