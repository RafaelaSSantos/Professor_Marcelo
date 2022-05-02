import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoCadastroComponent } from './aluno-cadastro/aluno-cadastro.component';
import { AlunoListarComponent } from './aluno-listar/aluno-listar.component';

const routes: Routes = [
  {path: 'alunos', component: AlunoListarComponent},
  {path: 'aluno', component: AlunoCadastroComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunoRoutingModule { }
