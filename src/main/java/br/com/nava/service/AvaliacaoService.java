package br.com.nava.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.nava.entity.Aluno;
import br.com.nava.entity.AlunoDisciplina;
import br.com.nava.entity.Avaliacao;
import br.com.nava.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	public List<Avaliacao> findAll(){
		return avaliacaoRepository.findAll();
	}
	
	//Paginação
	public Page<Avaliacao> buscaPorPaginacao(int pagina, int linhasPorPagina, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return new PageImpl<>(avaliacaoRepository.findAll(), pageRequest, linhasPorPagina);
	}
	
	public Avaliacao save(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}	
	
	public Avaliacao buscarPorAvaliacao(AlunoDisciplina alunoDisciplina) {
		return avaliacaoRepository.findByAlunoDisciplina(alunoDisciplina);
	}
}