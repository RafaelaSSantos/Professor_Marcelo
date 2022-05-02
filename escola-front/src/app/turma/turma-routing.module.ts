import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TurmaCadastroComponent } from './turma-cadastro/turma-cadastro.component';
import { TurmaListarComponent } from './turma-listar/turma-listar.component';

const routes: Routes = [
  {path: 'turmas', component: TurmaListarComponent},
  {path: 'turma', component: TurmaCadastroComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TurmaRoutingModule { }
