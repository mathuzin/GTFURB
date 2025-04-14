import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoordenadorRoutingModule } from './coordenador-routing.module';
import { CoordenadorComponent } from './coordenador.component';
import { NavRailCoordenadorComponent } from './nav-rail-coordenador/nav-rail-coordenador.component';
import { CoordenadorAvisosComponent } from './coordenador-avisos/coordenador-avisos.component';
import { CoordenadorCadastroPessoaComponent } from './coordenador-cadastro-pessoa/coordenador-cadastro-pessoa.component';
import { CoordenadorCadastroTurmaComponent } from './coordenador-cadastro-turma/coordenador-cadastro-turma.component';
import { CoordenadorEmailsComponent } from './coordenador-emails/coordenador-emails.component';
import { CoordenadorRelatorioComponent } from './coordenador-relatorio/coordenador-relatorio.component';
import { NavRailCoordenadorOrientadorComponent } from './nav-rail-coordenador-orientador/nav-rail-coordenador-orientador.component';
import { CoordenadorOrientadorRelatoriosComponent } from './coordenador-orientador-relatorios/coordenador-orientador-relatorios.component';

@NgModule({
  declarations: [
    CoordenadorComponent,
    NavRailCoordenadorComponent,
    NavRailCoordenadorOrientadorComponent,
    CoordenadorAvisosComponent,
    CoordenadorCadastroPessoaComponent,
    CoordenadorCadastroTurmaComponent,
    CoordenadorEmailsComponent,
    CoordenadorRelatorioComponent,
    CoordenadorOrientadorRelatoriosComponent,
  ],
  imports: [
    CommonModule,
    CoordenadorRoutingModule
  ],
})
export class CoordenadorModule {}
