import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoCadastroComponent } from './aluno-cadastro/aluno-cadastro.component';
import { AlunoListarComponent } from './aluno-listar/aluno-listar.component';


@NgModule({
  declarations: [
    AlunoCadastroComponent,
    AlunoListarComponent
  ],
  imports: [
    CommonModule,
    AlunoRoutingModule
  ]
})
export class AlunoModule { }
