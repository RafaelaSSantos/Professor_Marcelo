import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-cadastro',
  templateUrl: './aluno-cadastro.component.html',
  styleUrls: ['./aluno-cadastro.component.css']
})
export class AlunoCadastroComponent implements OnInit {

  meuForm : FormGroup = new FormGroup({});

  isEdicao : boolean = false;
  id : number = -1;

  constructor(
    private formBuilder: FormBuilder,
    private alunosService: AlunoService,
    private router:Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.meuForm = this.formBuilder.group({
      nome : [null, [Validators.required]],
      matricula : [null, [Validators.required]],
      turma : [null, [Validators.required]],
      disciplina : [null, [Validators.required]]
    })
  }

  onSubmit(){
    if (this.isEdicao == false){
      this.alunosService.save(this.meuForm.value)
      .subscribe(
        (data) => {
          console.log(data);this.router.navigate(['/aluno']);
        }
      );
    } else{
      this.alunosService.update(this.id, this.meuForm.value)
        .subscribe(
          (data) => {
            console.log(data);
            this.router.navigate(['/aluno']);
          }
        );
    }
  }

}
