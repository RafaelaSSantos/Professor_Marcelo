package br.com.nava.entity;

import javax.persistence.*;

@Entity
@Table(name = "DISCIPLINA")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
}