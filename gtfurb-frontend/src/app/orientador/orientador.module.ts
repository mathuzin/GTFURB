import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrientadorRoutingModule } from './orientador-routing.module';
import { OrientadorComponent } from './orientador.component';
import { NavRailOrientadorComponent } from './nav-rail-orientador/nav-rail-orientador.component';
import { OrientadorRelatorioComponent } from './orientador-relatorio/orientador-relatorio.component';
import { OrientadorAvisosComponent } from './orientador-avisos/orientador-avisos.component';

@NgModule({
  declarations: [
    OrientadorComponent,
    OrientadorRelatorioComponent,
    OrientadorAvisosComponent,
    NavRailOrientadorComponent,
  ],
  imports: [CommonModule, OrientadorRoutingModule],
})
export class OrientadorModule {}
