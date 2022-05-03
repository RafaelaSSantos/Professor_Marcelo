import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaRoutingModule } from './turma-routing.module';
import { TurmaCadastroComponent } from './turma-cadastro/turma-cadastro.component';
import { TurmaListarComponent } from './turma-listar/turma-listar.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    TurmaCadastroComponent,
    TurmaListarComponent
  ],
  imports: [
    CommonModule,
    TurmaRoutingModule,
    SharedModule
  ]
})
export class TurmaModule { }
