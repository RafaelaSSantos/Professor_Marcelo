import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaRoutingModule } from './turma-routing.module';
import { TurmaCadastroComponent } from './turma-cadastro/turma-cadastro.component';
import { TurmaListarComponent } from './turma-listar/turma-listar.component';


@NgModule({
  declarations: [
    TurmaCadastroComponent,
    TurmaListarComponent
  ],
  imports: [
    CommonModule,
    TurmaRoutingModule
  ]
})
export class TurmaModule { }
