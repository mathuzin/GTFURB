package com.example.gtfurb.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.services.PessoaRelatorioService;

@Controller
public class PessoaRelatorioControllers {

    private PessoaRelatorioService relatorioService;

    public PessoaRelatorioControllers(PessoaRelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaRelatorio>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarRelatorio(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.buscarPorId(id).getTxtRelatorio());
    }

    @PostMapping
    public ResponseEntity<PessoaRelatorio> salvarRelatorio(@RequestBody PessoaRelatorio relatorioFinal) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.salvar(relatorioFinal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaRelatorio> atualizarRelatorio(@PathVariable Long id, String novosDados) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.atualizar(id, novosDados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRelatorio(@PathVariable Long id) {
        relatorioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
