package com.example.gtfurb.utils;

import java.util.List;
import lombok.Generated;

public class Page<T> {
   private List<T> conteudo;
   private Long totalElementos;
   private Long totalPaginas;

   @Generated
   public List<T> getConteudo() {
      return this.conteudo;
   }

   @Generated
   public Long getTotalElementos() {
      return this.totalElementos;
   }

   @Generated
   public Long getTotalPaginas() {
      return this.totalPaginas;
   }

   @Generated
   public void setConteudo(final List<T> conteudo) {
      this.conteudo = conteudo;
   }

   @Generated
   public void setTotalElementos(final Long totalElementos) {
      this.totalElementos = totalElementos;
   }

   @Generated
   public void setTotalPaginas(final Long totalPaginas) {
      this.totalPaginas = totalPaginas;
   }

   @Generated
   public Page(final List<T> conteudo, final Long totalElementos, final Long totalPaginas) {
      this.conteudo = conteudo;
      this.totalElementos = totalElementos;
      this.totalPaginas = totalPaginas;
   }

   @Generated
   public Page() {
   }
}
