import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlunoComponent } from './usuarios/aluno/aluno.component';
import { CoordenadorComponent } from './usuarios/coordenador/coordenador.component';

@NgModule({
  declarations: [
    AppComponent,
    AlunoComponent,
    CoordenadorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
