package br.com.nava.service;

import java.util.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nava.entity.Disciplina;
import br.com.nava.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> listaTodasDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	public Disciplina buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Disciplina> optional = disciplinaRepository.findById(id);		
		return optional.orElseThrow(() -> new ObjectNotFoundException(null, "Disciplina não encontrada"));
	}
	
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public Disciplina alterar (Disciplina objDisciplina) {
		Disciplina disciplina = buscaPorID(objDisciplina.getId());
		disciplina.setNome(objDisciplina.getNome());
		return salvar(disciplina);
	}
	
	public void excluir(Integer id) {
		disciplinaRepository.deleteById(id);
	}
}