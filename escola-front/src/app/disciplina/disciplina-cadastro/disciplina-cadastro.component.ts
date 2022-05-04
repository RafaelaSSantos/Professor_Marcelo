import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DisciplinaService } from '../disciplina.service';

@Component({
  selector: 'app-disciplina-cadastro',
  templateUrl: './disciplina-cadastro.component.html',
  styleUrls: ['./disciplina-cadastro.component.css']
})
export class DisciplinaCadastroComponent implements OnInit {

  meuForm : FormGroup = new FormGroup({});

  isEdicao : boolean = false;
  id : number = -1;

  constructor(
    private formBuilder: FormBuilder,
    private disciplinaService:DisciplinaService,
    private router:Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.meuForm = this.formBuilder.group({
      nome : [null, [Validators.required]]
    })
  }

  onSubmit(){
    if (this.isEdicao == false){
      this.disciplinaService.save(this.meuForm.value)
      .subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['/disciplina']);
        }
      );
    } else{
      this.disciplinaService.update(this.id, this.meuForm.value)
        .subscribe(
          (data) => {
            console.log(data);
            this.router.navigate(['/disciplina']);
          }
        );
    }
  }
}
