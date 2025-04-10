import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoModule } from './aluno.module';
import { AlunoComponent } from './aluno.component';
import { AlunoRelatorioComponent } from './aluno-relatorio/aluno-relatorio.component';
import { AlunoAvisosComponent } from './aluno-avisos/aluno-avisos.component';

const routes: Routes = [
  { path: "", component: AlunoComponent},
  { path: "relatorios", component: AlunoRelatorioComponent},
  { path: "avisos", component: AlunoAvisosComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunoRoutingModule { }
