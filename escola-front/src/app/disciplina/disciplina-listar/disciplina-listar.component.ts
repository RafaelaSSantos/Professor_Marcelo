import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DisciplinaModel } from '../disciplina.model';
import { DisciplinaService } from '../disciplina.service';

@Component({
  selector: 'app-disciplina-listar',
  templateUrl: './disciplina-listar.component.html',
  styleUrls: ['./disciplina-listar.component.css']
})
export class DisciplinaListarComponent implements OnInit {

  disciplina : DisciplinaModel[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private disciplinaService: DisciplinaService
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.activatedRoute.params.subscribe(
      (data) => {}
    );
  }

  private getAll(){
    this.disciplinaService.getAll().subscribe(
      (data) => { this.disciplina = data },
    );
  }
}
