import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoordenadorComponent } from './coordenador.component';
import { CoordenadorRelatorioComponent } from './coordenador-relatorio/coordenador-relatorio.component';
import { CoordenadorCadastroPessoaComponent } from './coordenador-cadastro-pessoa/coordenador-cadastro-pessoa.component';
import { CoordenadorCadastroTurmaComponent } from './coordenador-cadastro-turma/coordenador-cadastro-turma.component';
import { CoordenadorEmailsComponent } from './coordenador-emails/coordenador-emails.component';
import { CoordenadorAvisosComponent } from './coordenador-avisos/coordenador-avisos.component';
import { CoordenadorOrientadorRelatoriosComponent } from './coordenador-orientador-relatorios/coordenador-orientador-relatorios.component';

const routes: Routes = [
  {path: '', component: CoordenadorComponent},
  {path: 'relatorios', component: CoordenadorRelatorioComponent},
  {path: 'orientador/relatorios', component: CoordenadorOrientadorRelatoriosComponent},
  {path: 'cadastro-pessoa', component: CoordenadorCadastroPessoaComponent},
  {path: 'cadastro-turma', component: CoordenadorCadastroTurmaComponent},
  {path: 'emails-enviados', component: CoordenadorEmailsComponent},
  {path: 'avisos', component: CoordenadorAvisosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoordenadorRoutingModule { }
