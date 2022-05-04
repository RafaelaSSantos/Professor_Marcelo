import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TurmaModel } from './turma.model';

@Injectable({
  providedIn: 'root'
})
export class TurmaService {
  constructor(private httpClient: HttpClient) {}
    getAll(){
      return this.httpClient.get<TurmaModel[]>('http://localhost:8080/api-sistema/turma');
    }


    save(turmaObj: TurmaModel){
      return this.httpClient.post<TurmaModel>('http://localhost:8080/api-sistema/turma',turmaObj);
    }

    delete(id : number){
    return this.httpClient.delete('http://localhost:8080/api-sistema/turma' + id);
    }

    getOne(id : number){
      return this.httpClient.get<TurmaModel>('http://localhost:8080/api-sistema/turma' + id);
    }

    update(id: number, turmaObj : TurmaModel){
      return this.httpClient.patch<TurmaModel>('http://localhost:8080/api-sistema/turma'+ id, turmaObj);
    }
}
