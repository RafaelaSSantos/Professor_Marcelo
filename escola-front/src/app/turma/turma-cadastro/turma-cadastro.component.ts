import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TurmaService } from '../turma.service';

@Component({
  selector: 'app-turma-cadastro',
  templateUrl: './turma-cadastro.component.html',
  styleUrls: ['./turma-cadastro.component.css']
})
export class TurmaCadastroComponent implements OnInit {


  meuForm : FormGroup = new FormGroup({});

  isEdicao : boolean = false;
  id : number = -1;

  constructor(
    private formBuilder: FormBuilder,
    private turmaService: TurmaService,
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
      this.turmaService.save(this.meuForm.value)
      .subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['/turma']);
        }
      );
    } else{
      this.turmaService.update(this.id, this.meuForm.value)
        .subscribe(
          (data) => {
            console.log(data);
            this.router.navigate(['/turma']);
          }
        );
    }
  }
}
