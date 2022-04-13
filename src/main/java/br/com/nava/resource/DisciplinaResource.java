package br.com.nava.resource;

import java.net.URI;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nava.constantes.Messages;
import br.com.nava.entity.Disciplina;
import br.com.nava.entity.Turma;
import br.com.nava.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name=Messages.SWAGGER_TAG_DISCIPLINA)
@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService  disciplinaService;
	
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>>listarDisciplina(){
		List<Disciplina> disciplina = disciplinaService.listaTodasDisciplinas();
		return ResponseEntity.ok().body(disciplina);
	}

	// Paginação
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Disciplina>> listarDisciplinasPorPaginacao(
			@RequestParam(value = "pagina", defaultValue = "0") int pagina,
			@RequestParam(value = "linhasPorPagina", defaultValue = "24") int linhasPorPagina,
			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<Disciplina> disciplinas = disciplinaService.buscaPorPaginacao(pagina, linhasPorPagina, direcao, orderBy);
		return ResponseEntity.ok().body(disciplinas);
	}
	
	@Operation(description = Messages.SWAGGER_GET_ONE)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> buscaPorID(@PathVariable Integer id) throws ObjectNotFoundException{
		Disciplina disciplina = disciplinaService.buscaPorID(id);
		return ResponseEntity.ok().body(disciplina);
	}
	
	@Operation(description = Messages.SWAGGER_POST)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Disciplina disciplina){
		Disciplina objDisciplina = disciplinaService.salvar(disciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDisciplina.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Operation(description = Messages.SWAGGER_PUT)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar( @PathVariable Integer id, @RequestBody Disciplina objDisciplina){
		objDisciplina.setId(id);
		disciplinaService.alterar(objDisciplina);
		return ResponseEntity.noContent().build();
	}
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir (@PathVariable Integer id){
		disciplinaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}