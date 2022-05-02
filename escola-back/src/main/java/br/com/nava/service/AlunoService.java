package br.com.nava.service;

import java.util.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.com.nava.entity.Aluno;
import br.com.nava.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listaTodosAlunos(){
		return alunoRepository.findAll();
	}
	
	//Paginação
	public Page<Aluno> buscaPorPaginacao(int pagina, int linhasPorPagina, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return new PageImpl<>(alunoRepository.findAll(), pageRequest, linhasPorPagina);
	}
	
	public Aluno buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(null, "Aluno não encontrado"));
	}
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void excluir(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	public Aluno alterar(Aluno objAluno) {
		Aluno aluno =  buscaPorID(objAluno.getId());
		aluno.setNome(objAluno.getNome());
		aluno.setTurma(objAluno.getTurma());
		aluno.setDisciplinas(objAluno.getDisciplinas());
		return salvar(aluno);
	}
}