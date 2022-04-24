package br.com.nava.entity;

import javax.persistence.*;

@Entity
@Table(name = "TURMA")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	public Integer getId() {	return id;}
	public void setId(Integer id) {this.id = id;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
}