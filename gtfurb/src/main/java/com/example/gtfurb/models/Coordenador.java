package main.java.com.example.gtfurb;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "coordenador")
public class Coordenador extends ModelImpl {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nm_coordenador", nullable = false, length = 100)
    private String nome;

    @Column(name = "email_coordenador", nullable = false, length = 100)
    private String email;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

