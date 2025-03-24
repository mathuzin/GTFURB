package com.example.gtfurb.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gtfurb.models.Usuarios.Aluno;
import com.example.gtfurb.services.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{idAluno}")
    public Aluno buscarAlunoPorId(@PathVariable("idAluno") Integer idAluno) {
        return alunoService.buscarAlunoPorId(idAluno);
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }

    @PutMapping("/{idAluno}")
    public Aluno atualizarAluno(@RequestBody Aluno aluno, @PathVariable("idAluno") Integer idAluno) {
        return alunoService.atualizarAluno(aluno, idAluno);
    }

    @DeleteMapping("/{idAluno}")
    public void excluirAluno(@PathVariable("idAluno") Integer idAluno) {
        alunoService.excluirAluno(idAluno);
    }

}

