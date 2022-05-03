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
}
