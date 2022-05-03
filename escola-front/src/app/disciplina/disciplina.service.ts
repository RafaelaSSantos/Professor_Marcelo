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

}
