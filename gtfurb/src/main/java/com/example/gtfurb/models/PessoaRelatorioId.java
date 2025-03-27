package com.example.gtfurb.models;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRelatorioId implements Serializable {

    private Integer idPessoa;
    private Integer idRelatorio;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaRelatorioId that = (PessoaRelatorioId) o;
        return Objects.equals(idPessoa, that.idPessoa) && Objects.equals(idRelatorio, that.idRelatorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, idRelatorio);
    }
}
