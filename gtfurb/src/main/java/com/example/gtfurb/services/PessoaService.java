package com.example.gtfurb.services;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.models.enums.TipoPessoa;
import com.example.gtfurb.repository.PessoaRepository;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaRelatorioService pessoaRelatorioService;

    @Autowired
    private RelatorioRepository relatorioService;

    public List<Pessoa> buscarCoordenadores() {
        return pessoaRepository.findByTipoPessoa(TipoPessoa.COORDENADOR);
    }

    public List<Pessoa> buscarOrientadores() {
        return pessoaRepository.findByTipoPessoa(TipoPessoa.ORIENTADOR);
    }

    public Pessoa buscarOrientadorPeloId(Integer idOrientador) {
        Pessoa orientador = pessoaRepository.findById(idOrientador)
                .orElseThrow(() -> new EntityNotFoundException("Orientador não encontrado."));

        if (orientador.getTipoPessoa() != TipoPessoa.ORIENTADOR) {
            throw new RuntimeException("A pessoa encontrada não é um orientador.");
        }
        return orientador;
    }

    public Pessoa buscarCoordenadorPeloId(Integer idCoordenador) {
        Pessoa coordenador = pessoaRepository.findById(idCoordenador)
                .orElseThrow(() -> new EntityNotFoundException("Coordenador não encontrado."));

        if (coordenador.getTipoPessoa() != TipoPessoa.COORDENADOR) {
            throw new RuntimeException("A pessoa encontrada não é um coordenador.");
        }
        return coordenador;
    }

    public List<Pessoa> buscarAlunosSemOrientador() {
        return pessoaRepository.findByTipoPessoaAndOrientadorIsNull(TipoPessoa.ALUNO);
    }

    public List<Pessoa> buscarAlunosPorOrientador(Integer idOrientador) {
        return pessoaRepository.findByTipoPessoaAndOrientadorId(TipoPessoa.ALUNO, idOrientador);
    }

    public Pessoa criarAluno(Pessoa aluno) {

        if (aluno.getNome() == null || aluno.getNome().isEmpty() || aluno.getEmail() == null
                || aluno.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        if (aluno.getTipoPessoa() == TipoPessoa.ALUNO && aluno.getOrientador() == null) {
            throw new IllegalArgumentException("Orientador é obrigatório para alunos.");
        }

        return pessoaRepository.save(aluno);
    }

    public Pessoa criarOrientador(Pessoa orientador) {

        if (orientador.getNome() == null || orientador.getNome().isEmpty() || orientador.getEmail() == null
                || orientador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        return pessoaRepository.save(orientador);
    }

    public Pessoa criarCoordenador(Pessoa coordenador) {

        if (coordenador.getNome() == null || coordenador.getNome().isEmpty() || coordenador.getEmail() == null
                || coordenador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        return pessoaRepository.save(coordenador);
    }

    public Pessoa alterarPessoa(Integer idPessoa, String nomePessoa, String emailPessoa, Pessoa orientador) {

        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

        pessoa.setNome(nomePessoa);
        pessoa.setEmail(emailPessoa);
        pessoa.setOrientador(orientador);

        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Integer idPessoa) {

        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

        pessoaRepository.delete(pessoa);
    }

    public PessoaRelatorio salvarPessoaRelatorio(PessoaRelatorio pessoaRelatorio) {
        return pessoaRelatorioService.salvar(pessoaRelatorio);
    }

    public PessoaRelatorio atualizarPessoaRelatorio(Integer id, String novoTxt, float tempoRelatorio) {
        return pessoaRelatorioService.atualizar(id, novoTxt, tempoRelatorio);
    }

    public void deletarPessoaRelatorio(Integer id) {
        pessoaRelatorioService.deletar(id);
    }

    public Relatorio salvarRelatorio(Relatorio relatorioFinal) {
        return relatorioService.salvar(relatorioFinal);
    }

    public Relatorio atualizarRelatorio(Integer id, String novoTitulo, LocalDate novoDataInicio,
            LocalDate novoDataTermino) {
        return relatorioService.atualizar(id, novoTitulo, novoDataInicio, novoDataTermino);
    }

    public void deletarRelatorio(Integer id) {
        relatorioService.deletar(id);
    }

}
