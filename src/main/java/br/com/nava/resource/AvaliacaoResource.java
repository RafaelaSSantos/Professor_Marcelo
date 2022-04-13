package br.com.nava.resource;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nava.constantes.Messages;
import br.com.nava.entity.Aluno;
import br.com.nava.entity.AlunoDisciplina;
import br.com.nava.entity.Avaliacao;
import br.com.nava.entity.Disciplina;
import br.com.nava.entity.Turma;
import br.com.nava.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name=Messages.SWAGGER_TAG_AVALIACAO)
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoService avaliacaoService;

	@Operation(description = Messages.SWAGGER_GET_ALL)
	@GetMapping
	public ResponseEntity<List<Avaliacao>> listarAvaliacao(){
		List<Avaliacao> listaAvaliacao = avaliacaoService.findAll();
		return ResponseEntity.ok().body(listaAvaliacao);
	}
	
	// Paginação
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Avaliacao>> listarAvasPorPaginacao(
			@RequestParam(value = "pagina", defaultValue = "0") int pagina,
			@RequestParam(value = "linhasPorPagina", defaultValue = "24") int linhasPorPagina,
			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<Avaliacao> avas = avaliacaoService.buscaPorPaginacao(pagina, linhasPorPagina, direcao, orderBy);
		return ResponseEntity.ok().body(avas);
	}
	
	@Operation(description = Messages.SWAGGER_GET_ONE)
	@RequestMapping(value = "/{idAluno}/{idDisciplina}", method = RequestMethod.GET)
	public ResponseEntity<Avaliacao> buscarPorAvaliacao(@PathVariable Integer idAluno, @PathVariable Integer idDisciplina){
		Aluno aluno = new Aluno();
		aluno.setId(idAluno);
		
		Disciplina disciplina = new Disciplina();
		disciplina.setId(idDisciplina);
		
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		alunoDisciplina.setAluno(aluno);
		alunoDisciplina.setDisciplina(disciplina);
		
		Avaliacao avaliacao = avaliacaoService.buscarPorAvaliacao(alunoDisciplina);		 
		return ResponseEntity.ok().body(avaliacao); 		
	}
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Avaliacao objAvaliacao){
		objAvaliacao = avaliacaoService.save(objAvaliacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objAvaliacao.getAlunoDisciplina()).toUri();
		return ResponseEntity.created(uri).build();
	}
}