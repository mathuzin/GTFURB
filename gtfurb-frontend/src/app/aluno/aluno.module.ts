import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoComponent } from './aluno.component';
import { AlunoRelatorioComponent } from './aluno-relatorio/aluno-relatorio.component';
import { AlunoAvisosComponent } from './aluno-avisos/aluno-avisos.component';
import { NavRailAlunoComponent } from './nav-rail-aluno/nav-rail-aluno.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AlunoComponent,
    AlunoRelatorioComponent,
    AlunoAvisosComponent,
    NavRailAlunoComponent
  ],
  imports: [
    CommonModule,
    AlunoRoutingModule,
    FormsModule
  ]
})
export class AlunoModule { }
