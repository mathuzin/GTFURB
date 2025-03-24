package com.example.gtfurb.services;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.models.Usuarios.Aluno;
import com.example.gtfurb.models.Usuarios.Orientador;
import com.example.gtfurb.repository.AlunoRepository;
import com.example.gtfurb.repository.CoordenadorRepository;
import com.example.gtfurb.repository.OrientadorRepository;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadRepository;

    @Autowired
    private BCryptPasswordEncoder bCript;

    @Autowired
    private OrientadorRepository orientadorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;

    CoordenadorService() {

    }

    public Aluno criarAluno(String nome, String email, Integer orientadorId) {

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nome, e-mail e senha são obrigatórios.");
        }

        Orientador orientador = orientadorRepository.findById(orientadorId)
                .orElseThrow(() -> new EntityNotFoundException("Orientador não encontrado."));

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setOrientador(orientador);

        return alunoRepository.save(aluno);
    }

    public Orientador criarOrientador(String nome, String email) {

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        Orientador orientador = new Orientador();
        orientador.setNome(nome);
        orientador.setEmail(email);

        return orientadorRepository.save(orientador);
    }

    public Relatorio criarRelatorio(String titulo, LocalDate dataInicio, LocalDate dataTermino) {

        if (titulo.isEmpty() || titulo == null) {
            throw new IllegalArgumentException("Título é obrigatório.");
        }

        Relatorio relatorio = new Relatorio();
        relatorio.setTitulo(titulo);
        relatorio.setDataInicio(dataInicio);
        relatorio.setDataFim(dataTermino);

        return relatorioRepository.save(relatorio);
    }
}
