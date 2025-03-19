package main.java.com.example.gtfurb.models;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAluno;

    @Column(name = "nm_aluno", length = 100, nullable = false)
    private String nome;

    @Column(name = "email_aluno", length = 100, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_orientador", nullable = false)
    private Orientador orientador;

}
