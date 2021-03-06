package br.com.nava.entity;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	@ManyToMany
	@JoinTable(name ="matricula",joinColumns = {@JoinColumn(name = "id_aluno")}, 
	inverseJoinColumns = {@JoinColumn(name = "id_disciplina")})
	private List<Disciplina> disciplinas;

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public Turma getTurma() {return turma;}
	public void setTurma(Turma turma) {this.turma = turma;}
	public List<Disciplina> getDisciplinas() {return disciplinas;}
	public void setDisciplinas(List<Disciplina> disciplinas) {this.disciplinas = disciplinas;}	
	
}