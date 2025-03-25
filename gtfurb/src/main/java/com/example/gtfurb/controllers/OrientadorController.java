package com.example.gtfurb.controllers;

import com.example.gtfurb.models.Usuarios.Aluno;
import com.example.gtfurb.services.OrienatdorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orientador")
public class OrientadorController {

    @Autowired
    private OrienatdorService orientadorService;

    // DropDown
    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> buscarAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(orientadorService.buscarAlunos());
    }

    // DropDown
    @GetMapping("/alunos/{idAluno}/orientador/{idOrientador}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Integer idAluno, @PathVariable Integer idOrientador) {
        return ResponseEntity.status(HttpStatus.OK).body(orientadorService.buscarAlunoPorId(idAluno, idOrientador));
    }
}
