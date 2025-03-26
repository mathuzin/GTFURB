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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.services.PessoaRelatorioService;

@Controller
@RequestMapping("/relatorioPessoa")
public class PessoaRelatorioControllers {

    private PessoaRelatorioService relatorioService;

    public PessoaRelatorioControllers(PessoaRelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<PessoaRelatorio>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarRelatorio(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.buscarPorId(id).getTxtRelatorio());
    }

    // POST
    @PostMapping
    public ResponseEntity<PessoaRelatorio> salvarRelatorio(@RequestBody PessoaRelatorio relatorioFinal) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.salvar(relatorioFinal));
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<PessoaRelatorio> atualizarRelatorio(@PathVariable Integer id, String novosDados,
            float horasGastas) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.atualizar(id, novosDados, horasGastas));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRelatorio(@PathVariable Integer id) {
        relatorioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
