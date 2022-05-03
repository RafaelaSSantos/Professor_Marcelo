import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DisciplinaRoutingModule } from './disciplina-routing.module';
import { DisciplinaListarComponent } from './disciplina-listar/disciplina-listar.component';
import { DisciplinaCadastroComponent } from './disciplina-cadastro/disciplina-cadastro.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    DisciplinaListarComponent,
    DisciplinaCadastroComponent
  ],
  imports: [
    CommonModule,
    DisciplinaRoutingModule,
    SharedModule
  ]
})
export class DisciplinaModule { }
