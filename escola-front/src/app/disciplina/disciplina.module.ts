import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DisciplinaRoutingModule } from './disciplina-routing.module';
import { DisciplinaListarComponent } from './disciplina-listar/disciplina-listar.component';
import { DisciplinaCadastroComponent } from './disciplina-cadastro/disciplina-cadastro.component';


@NgModule({
  declarations: [
    DisciplinaListarComponent,
    DisciplinaCadastroComponent
  ],
  imports: [
    CommonModule,
    DisciplinaRoutingModule
  ]
})
export class DisciplinaModule { }
