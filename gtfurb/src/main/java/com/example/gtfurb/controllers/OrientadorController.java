package com.example.gtfurb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gtfurb.services.OrienatdorService;

@Controller
@RequestMapping("/orientador")
public class OrientadorController {

    private OrienatdorService orienatdorService;
}
