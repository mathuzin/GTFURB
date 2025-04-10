import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrientadorComponent } from './orientador.component';

const routes: Routes = [{ path: '', component: OrientadorComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class OrientadorRoutingModule {}
