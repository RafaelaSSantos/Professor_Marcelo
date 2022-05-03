import { DisciplinaModel } from "../disciplina/disciplina.model";

export class AlunoModel{
  id? : number;
  nome? : String;
  disciplinas? : DisciplinaModel[];
 }
