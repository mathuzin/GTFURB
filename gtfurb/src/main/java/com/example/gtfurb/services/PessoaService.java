package com.example.gtfurb.services;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.models.enums.TipoCurso;
import com.example.gtfurb.models.enums.TipoPessoa;
import com.example.gtfurb.repository.PessoaRelatorioRepository;
import com.example.gtfurb.repository.PessoaRepository;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private PessoaRelatorioRepository pessoaRelatorioRepository;

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

    public Pessoa criarAluno(String nome, String email, Integer orientadorId, TipoCurso tipoCurso) {

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        Pessoa orientador = pessoaRepository.findById(orientadorId)
                .orElseThrow(() -> new EntityNotFoundException("Orientador não encontrado."));

        Pessoa aluno = new Pessoa();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setTipoPessoa(TipoPessoa.ALUNO);
        aluno.setOrientador(orientador);
        aluno.setTipoCurso(tipoCurso);

        return pessoaRepository.save(aluno);
    }

    public Pessoa criarOrientador(String nome, String email) {

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        Pessoa orientador = new Pessoa();
        orientador.setNome(nome);
        orientador.setEmail(email);
        orientador.setTipoPessoa(TipoPessoa.ORIENTADOR);

        return pessoaRepository.save(orientador);
    }

    public Pessoa criarCoordenador(String nome, String email) {

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        Pessoa coordenador = new Pessoa();
        coordenador.setNome(nome);
        coordenador.setEmail(email);
        coordenador.setTipoPessoa(TipoPessoa.COORDENADOR);

        return pessoaRepository.save(coordenador);
    }

    public Relatorio criarRelatorio(String titulo, LocalDate dataInicio, LocalDate dataTermino) {

        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título é obrigatório.");
        }

        Relatorio relatorio = new Relatorio();
        relatorio.setTxt_titulo(titulo);
        relatorio.setDataInicio(dataInicio);
        relatorio.setDataTermino(dataTermino);

        return relatorioRepository.save(relatorio);
    }

    public PessoaRelatorio criarPessoaRelatorio(Integer idPessoa, String txtRelatorio, LocalDate dataInicio,
            Float tempoGasto) {

        if (txtRelatorio == null || txtRelatorio.isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }

        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

        if (pessoa.getTipoPessoa() == TipoPessoa.ALUNO) {
            if (tempoGasto == null || tempoGasto <= 0) {
                throw new IllegalArgumentException("O tempo gasto é obrigatório para alunos e deve ser maior que 0.");
            }
        } else {
            tempoGasto = 0f;
        }

        PessoaRelatorio pessoaRelatorio = new PessoaRelatorio();
        pessoaRelatorio.setIdPessoa(idPessoa);
        pessoaRelatorio.setTxtRelatorio(txtRelatorio);
        pessoaRelatorio.setDataInicio(dataInicio);
        pessoaRelatorio.setTempoGasto(tempoGasto);

        return pessoaRelatorioRepository.save(pessoaRelatorio);
    }

}
