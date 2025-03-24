package com.example.gtfurb.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Usuarios.Aluno;
import com.example.gtfurb.models.Usuarios.Orientador;
import com.example.gtfurb.repository.AlunoRepository;
import com.example.gtfurb.repository.CoordenadorRepository;
import com.example.gtfurb.repository.OrientadorRepository;

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

    CoordenadorService() {

    }

    public Aluno criarAluno(String nome, String email, String senha, Integer orientadorId) {

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Nome, e-mail e senha são obrigatórios.");
        }

        Orientador orientador = orientadorRepository.findById(orientadorId)
                .orElseThrow(() -> new EntityNotFoundException("Orientador não encontrado."));

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setSenha(bCript.encode(senha));
        aluno.setOrientador(orientador);

        return alunoRepository.save(aluno);
    }
}
