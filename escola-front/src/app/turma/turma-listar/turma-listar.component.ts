import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TurmaModel } from '../turma.model';
import { TurmaService } from '../turma.service';

@Component({
  selector: 'app-turma-listar',
  templateUrl: './turma-listar.component.html',
  styleUrls: ['./turma-listar.component.css']
})
export class TurmaListarComponent implements OnInit {

  turma : TurmaModel[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private turmasService: TurmaService
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.activatedRoute.params.subscribe(
      (data) => {}
    );
  }

  private getAll(){
    this.turmasService.getAll().subscribe(
      (data) => { this.turma = data },
    );
  }
}
