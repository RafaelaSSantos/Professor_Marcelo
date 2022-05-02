package br.com.nava.service;

import java.util.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.com.nava.entity.*;
import br.com.nava.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> listaTodasDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	//Paginação
	public Page<Disciplina> buscaPorPaginacao(int pagina, int linhasPorPagina, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return new PageImpl<>(disciplinaRepository.findAll(), pageRequest, linhasPorPagina);
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