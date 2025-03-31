package com.example.gtfurb.controllers;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.PessoaRelatorioId;
import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.services.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // GET
    @GetMapping("/coordenadores")
    public List<Pessoa> buscarCoordenadores() {
        return pessoaService.buscarCoordenadores();
    }

    @GetMapping("/orientadores")
    public List<Pessoa> buscarOrientadores() {
        return pessoaService.buscarOrientadores();
    }

    @GetMapping("/orientador/{id}")
    public ResponseEntity<Pessoa> buscarOrientadorPeloId(@PathVariable Integer id) {
        Pessoa orientador = pessoaService.buscarOrientadorPeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(orientador);
    }

    @GetMapping("/coordenador/{id}")
    public ResponseEntity<Pessoa> buscarCoordenadorPeloId(@PathVariable Integer id) {
        Pessoa coordenador = pessoaService.buscarCoordenadorPeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(coordenador);
    }

    @GetMapping("/alunos/sem-orientador")
    public List<Pessoa> buscarAlunosSemOrientador() {
        return pessoaService.buscarAlunosSemOrientador();
    }

    @GetMapping("/alunos/orientador/{id}")
    public List<Pessoa> buscarAlunosPorOrientador(@PathVariable Integer id) {
        return pessoaService.buscarAlunosPorOrientador(id);
    }

    // POST
    @PostMapping("/aluno")
    public ResponseEntity<Pessoa> criarAluno(@RequestBody Pessoa aluno) {
        Pessoa alunoCriado = pessoaService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriado);
    }

    @PostMapping("/orientador")
    public ResponseEntity<Pessoa> criarOrientador(@RequestBody Pessoa orientador) {
        Pessoa orientadorCriado = pessoaService.criarOrientador(orientador);
        return ResponseEntity.status(HttpStatus.CREATED).body(orientadorCriado);
    }

    @PostMapping("/coordenador")
    public ResponseEntity<Pessoa> criarCoordenador(@RequestBody Pessoa coordenador) {
        Pessoa coordenadorCriado = pessoaService.criarCoordenador(coordenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(coordenadorCriado);
    }

    @PostMapping("/relatorioPessoa")
    public ResponseEntity<PessoaRelatorio> salvarPessoaRelatorio(@RequestBody PessoaRelatorio pessoaRelatorio) {
        PessoaRelatorio relatorioSalvo = pessoaService.salvarPessoaRelatorio(pessoaRelatorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioSalvo);
    }

    @PostMapping("/relatorio/salvar")
    public ResponseEntity<Relatorio> salvarRelatorio(@RequestBody Relatorio relatorioFinal) {
        Relatorio relatorioSalvo = pessoaService.salvarRelatorio(relatorioFinal);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioSalvo);
    }

    // PUT
    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> alterarPessoa(@PathVariable Integer id,
            @RequestBody Pessoa pessoaAlterada) {
        Pessoa pessoaAtualizada = pessoaService.alterarPessoa(id, pessoaAlterada.getNome(), pessoaAlterada.getEmail(),
                pessoaAlterada.getOrientador());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
    }

    @PutMapping("/pessoaRelatorio/{id}")
    public ResponseEntity<PessoaRelatorio> atualizarPessoaRelatorio(
            @PathVariable PessoaRelatorioId id,
            @RequestParam String novoTxt,
            @RequestParam float tempoRelatorio) {
        PessoaRelatorio relatorioAtualizado = pessoaService.atualizarPessoaRelatorio(id, novoTxt, tempoRelatorio);
        return ResponseEntity.status(HttpStatus.OK).body(relatorioAtualizado);
    }

    @PutMapping("/relatorio/{id}")
    public ResponseEntity<Relatorio> atualizarRelatorio(
            @PathVariable Integer id,
            @RequestParam String novoTitulo,
            @RequestParam LocalDate novoDataInicio,
            @RequestParam LocalDate novoDataTermino) {
        Relatorio relatorioAtualizado = pessoaService.atualizarRelatorio(id, novoTitulo, novoDataInicio,
                novoDataTermino);
        return ResponseEntity.status(HttpStatus.OK).body(relatorioAtualizado);
    }

    // DELETE
    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Integer id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pessoaRelatorio/{id}")
    public ResponseEntity<Void> deletarPessoaRelatorio(@PathVariable PessoaRelatorioId id) {
        pessoaService.deletarPessoaRelatorio(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/relatorio/{id}")
    public ResponseEntity<Void> deletarRelatorio(@PathVariable Integer id) {
        pessoaService.deletarRelatorio(id);
        return ResponseEntity.noContent().build();
    }
}