import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'aluno',
    loadChildren: () =>
      import('./aluno/aluno.module').then((m) => m.AlunoModule),
  },
  {
    path: 'orientador',
    loadChildren: () =>
      import('./orientador/orientador.module').then((m) => m.OrientadorModule),
  },
  {
    path: 'coordenador',
    loadChildren: () =>
      import('./coordenador/coordenador.module').then(
        (m) => m.CoordenadorModule
      ),
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./login/login.module').then((m) => m.LoginModule),
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
