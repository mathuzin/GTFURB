package com.example.gtfurb.models;

import java.io.Serializable;
import java.util.Objects;

public class PessoaRelatorioId implements Serializable {

    private Integer idPessoa;
    private Integer idRelatorio;

    public PessoaRelatorioId(Integer idPessoa, Integer idRelatorio) {
        this.idPessoa = idPessoa;
        this.idRelatorio = idRelatorio;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Integer idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaRelatorioId that = (PessoaRelatorioId) o;
        return Objects.equals(idPessoa, that.idPessoa) &&
               Objects.equals(idRelatorio, that.idRelatorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, idRelatorio);
    }
}
