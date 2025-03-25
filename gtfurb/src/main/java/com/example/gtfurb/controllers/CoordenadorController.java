package com.example.gtfurb.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.models.Usuarios.Aluno;
import com.example.gtfurb.models.Usuarios.Orientador;
import com.example.gtfurb.services.CoordenadorService;

@Controller
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    // DropDown
    @GetMapping("/orientadores")
    public ResponseEntity<List<Orientador>> buscarOrientadores() {
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorService.buscarOrientador());
    }

    // DropDown
    @GetMapping("/orientadores/{id}")
    public ResponseEntity<Orientador> buscarOrientadorPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorService.buscarOrientadorPeloId(id));
    }

    // DropDown
    @GetMapping("/alunos/sem-orientador")
    public ResponseEntity<List<Aluno>> buscarAlunosSemOrientador() {
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorService.buscarAlunosSemOrientador());
    }

    // DropDown
    @GetMapping("/alunos/por-orientador/{idOrientador}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorOrientador(@PathVariable Integer idOrientador) {
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorService.buscarAlunosPorOrientador(idOrientador));
    }

    // PopUp/Janela na própria página
    @PostMapping("/alunos")
    public ResponseEntity<Aluno> criarAluno(@RequestParam String nome, @RequestParam String email,
            @RequestParam Integer orientadorId) {
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorService.criarAluno(nome, email, orientadorId));
    }

    // PopUp/Janela na própria página
    @PostMapping("/orientadores")
    public ResponseEntity<Orientador> criarOrientador(@RequestParam String nome, @RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorService.criarOrientador(nome, email));
    }

    // PopUp/Janela na própria página
    @PostMapping("/relatorios")
    public ResponseEntity<Relatorio> criarRelatorio(@RequestParam String titulo, @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataTermino) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(coordenadorService.criarRelatorio(titulo, dataInicio, dataTermino));
    }
}
