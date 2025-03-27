import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrientadorRoutingModule } from './orientador-routing.module';
import { OrientadorComponent } from './orientador.component';


@NgModule({
  declarations: [
    OrientadorComponent
  ],
  imports: [
    CommonModule,
    OrientadorRoutingModule
  ]
})
export class OrientadorModule { }
