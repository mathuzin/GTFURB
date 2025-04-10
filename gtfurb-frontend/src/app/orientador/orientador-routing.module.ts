import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrientadorComponent } from './orientador.component';
import { OrientadorRelatorioComponent } from './orientador-relatorio/orientador-relatorio.component';
import { OrientadorAvisosComponent } from './orientador-avisos/orientador-avisos.component';

const routes: Routes = [
  { path: '', component: OrientadorComponent }, // Quando coloca orientador ele aparece a pagina mas quando clica na img ele não volta pra ela
  { path: 'relatorios', component: OrientadorRelatorioComponent },
  { path: 'avisos', component: OrientadorAvisosComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class OrientadorRoutingModule {}
