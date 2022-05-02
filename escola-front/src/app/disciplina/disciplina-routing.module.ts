import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisciplinaCadastroComponent } from './disciplina-cadastro/disciplina-cadastro.component';
import { DisciplinaListarComponent } from './disciplina-listar/disciplina-listar.component';

const routes: Routes = [
  {path: 'disciplinas', component: DisciplinaListarComponent},
  {path: 'disciplina', component: DisciplinaCadastroComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DisciplinaRoutingModule { }
