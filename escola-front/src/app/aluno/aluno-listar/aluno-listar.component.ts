import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DisciplinaModel } from 'src/app/disciplina/disciplina.model';
import { DisciplinaService } from 'src/app/disciplina/disciplina.service';
import { AlunoModel } from '../aluno.model';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-listar',
  templateUrl: './aluno-listar.component.html',
  styleUrls: ['./aluno-listar.component.css']
})

export class AlunoListarComponent implements OnInit {

  alunos : AlunoModel[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private alunosService: AlunoService
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.activatedRoute.params.subscribe(
      (data ) => { }
    );
  }

  private getAll(){
    this.alunosService.getAll().subscribe(
      (data) => { this.alunos = data },
    );
  }

}
