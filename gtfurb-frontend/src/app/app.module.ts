import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { IonicModule } from '@ionic/angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { LoginModule } from './login/login.module';
import { FormsModule } from '@angular/forms';
import { AlunoModule } from './aluno/aluno.module';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSidenavModule,
    IonicModule.forRoot(),
    IonicModule.forRoot({}),
    LoginModule,
    AlunoModule,
    FormsModule
  ]
  ,
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

