package br.com.nava.service;

import java.util.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.com.nava.entity.Turma;
import br.com.nava.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Turma> listaTodasTurmas(){
		return turmaRepository.findAll();
	}	
	
	//Paginação
	public Page<Turma> buscarPorPaginacao(int pagina, int linhasPorPagina, String direction, String orderBy){
		PageRequest pageResquest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return new PageImpl<>(turmaRepository.findAll(), pageResquest, linhasPorPagina);
	}
	
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> optional = turmaRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(null, "Turma não encontrada"));
	}
	
	public Turma salvar(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma alterar(Turma objTurma) {
		Turma turma = buscaPorID(objTurma.getId());
		turma.setNome(objTurma.getNome());
		return salvar(turma);
	}
	
	public void excluir(Integer id) {
		turmaRepository.deleteById(id);
	}
}