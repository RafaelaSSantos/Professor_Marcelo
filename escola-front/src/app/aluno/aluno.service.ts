import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AlunoModel } from './aluno.model';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  constructor(private httpClient: HttpClient) {}
    getAll(){
      return this.httpClient.get<AlunoModel[]>('http://localhost:8080/api-sistema/aluno');
    }


  save(alunoObj: AlunoModel){
    return this.httpClient.post<AlunoModel>('http://localhost:8080/api-sistema/aluno', alunoObj);
  }

  delete(id : number){
  return this.httpClient.delete('http://localhost:8080/api-sistema/aluno' + id);
  }

  getOne(id : number){
    return this.httpClient.get<AlunoModel>('http://localhost:8080/api-sistema/aluno' + id);
  }

  update(id: number, alunoObj : AlunoModel){
    return this.httpClient.patch<AlunoModel>('http://localhost:8080/api-sistema/aluno'+ id, alunoObj);
  }
}
