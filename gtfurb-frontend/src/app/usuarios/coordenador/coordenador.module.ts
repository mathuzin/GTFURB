import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoordenadorRoutingModule } from './coordenador-routing.module';
import { CoordenadorComponent } from './coordenador.component';


@NgModule({
  declarations: [
    CoordenadorComponent
  ],
  imports: [
    CommonModule,
    CoordenadorRoutingModule
  ]
})
export class CoordenadorModule { }
