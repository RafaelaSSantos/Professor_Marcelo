import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AlunoModel } from './aluno.model';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  constructor(private httpClient: HttpClient) {}
    getAll() : Observable<any>{
      return this.httpClient.get<AlunoModel[]>('http://localhost:8080/api-sistema/aluno');
    }
}
