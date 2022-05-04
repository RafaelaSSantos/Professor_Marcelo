import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DisciplinaModel } from './disciplina.model';

@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {

  constructor(private httpClient: HttpClient) {}

    getAll(){
      return this.httpClient.get<DisciplinaModel[]>('http://localhost:8080/api-sistema/disciplina');
    }

    save(disciplinaObj: DisciplinaModel){
      return this.httpClient.post<DisciplinaModel>('http://localhost:8080/api-sistema/disciplina', disciplinaObj);
    }

    delete(id : number){
    return this.httpClient.delete('http://localhost:8080/api-sistema/disciplina' + id);
    }

    getOne(id : number){
      return this.httpClient.get<DisciplinaModel>('http://localhost:8080/api-sistema/disciplina' + id);
    }

    update(id: number, disciplinaObj : DisciplinaModel){
      return this.httpClient.patch<DisciplinaModel>('http://localhost:8080/api-sistema/disciplina'+ id, disciplinaObj);
    }
}
