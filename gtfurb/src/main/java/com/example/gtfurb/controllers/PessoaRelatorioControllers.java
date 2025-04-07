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
import com.example.gtfurb.models.PessoaRelatorioId;
import com.example.gtfurb.services.PessoaRelatorioService;

@Controller
@RequestMapping("/relatorioPessoa")
public class PessoaRelatorioControllers {

    private final PessoaRelatorioService relatorioService;

    public PessoaRelatorioControllers(PessoaRelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<PessoaRelatorio>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.listarTodos());
    }

    @GetMapping("/{idPessoa}/{idRelatorio}")
    public ResponseEntity<PessoaRelatorio> buscarRelatorio(@PathVariable Integer idPessoa,
            @PathVariable Integer idRelatorio) {
        PessoaRelatorioId id = new PessoaRelatorioId(idPessoa, idRelatorio);
        PessoaRelatorio relatorio = relatorioService.buscarPorId(id);
        return ResponseEntity.ok(relatorio);
    }

    // POST
    @PostMapping
    public ResponseEntity<PessoaRelatorio> salvarRelatorio(@RequestBody PessoaRelatorio relatorioFinal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioService.salvar(relatorioFinal));
    }

    // PUT
    @PutMapping("/{idPessoa}/{idRelatorio}")
    public ResponseEntity<PessoaRelatorio> atualizarRelatorio(
            @PathVariable Integer idPessoa, @PathVariable Integer idRelatorio,
            @RequestBody PessoaRelatorio dadosAtualizados) {
        PessoaRelatorioId id = new PessoaRelatorioId(idPessoa, idRelatorio);
        PessoaRelatorio relatorioAtualizado = relatorioService.atualizar(
                id, dadosAtualizados.getTxtRelatorio(), dadosAtualizados.getTempoGasto());
        return ResponseEntity.ok(relatorioAtualizado);
    }

    // DELETE
    @DeleteMapping("/{idPessoa}/{idRelatorio}")
    public ResponseEntity<Void> excluirRelatorio(@PathVariable Integer idPessoa, @PathVariable Integer idRelatorio) {
        PessoaRelatorioId id = new PessoaRelatorioId(idPessoa, idRelatorio);
        relatorioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}