import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoCadastroComponent } from './aluno-cadastro/aluno-cadastro.component';
import { AlunoListarComponent } from './aluno-listar/aluno-listar.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    AlunoCadastroComponent,
    AlunoListarComponent

  ],
  imports: [
    CommonModule,
    AlunoRoutingModule,
    SharedModule
  ]
})
export class AlunoModule { }
