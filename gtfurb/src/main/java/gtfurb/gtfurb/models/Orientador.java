package br.furb.inf.furbot.models.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.furb.inf.furbot.models.ModelImpl;

@Entity
@Table(name = "coordenador")
public class Orientador extends ModelImpl {

    @Id
    @Column(nullable = true, name = "id_coordenador")
    private int idCoordenador;

    @Column(nullable = true, name = "nm_coordenador")
    private String nmCoordenador;

    @Column(nullable = true, name = "email_coordenador")
    private String emailCoordenador;
}
