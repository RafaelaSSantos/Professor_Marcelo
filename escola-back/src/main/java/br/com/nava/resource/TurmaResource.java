package br.com.nava.resource;

import java.net.URI;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.nava.constantes.Messages;
import br.com.nava.entity.Turma;
import br.com.nava.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = Messages.SWAGGER_TAG_TURMA)
@RestController
@RequestMapping("/turma")
public class TurmaResource {

	@Autowired
	private TurmaService turmaService;

	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Turma>> listarTurmas() {
		List<Turma> turmas = turmaService.listaTodasTurmas();
		return ResponseEntity.ok().body(turmas);
	}

	// Paginação
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Turma>> listarTurmasPorPaginacao(
			@RequestParam(value = "pagina", defaultValue = "0") int pagina,
			@RequestParam(value = "linhasPorPagina", defaultValue = "24") int linhasPorPagina,
			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<Turma> turmas = turmaService.buscarPorPaginacao(pagina, linhasPorPagina, direcao, orderBy);
		return ResponseEntity.ok().body(turmas);
	}

	//Exemplificando o uso de paginação para acessar por restrição
	// Paginação
//	@GetMapping(value = "/V1/page")
//	public ResponseEntity<Page<Turma>> listarTurmasPorPaginacaoV1(
//			@RequestParam(value = "pagina", defaultValue = "0") int pagina,
//			@RequestParam(value = "linhasPorPagina", defaultValue = "24") int linhasPorPagina,
//			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao,
//			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
//		Page<Turma> turmas = turmaService.buscarPorPaginacao(pagina, linhasPorPagina, direcao, orderBy);
//		return ResponseEntity.ok().body(turmas);
//	}
//	// Paginação restritiva
//	@GetMapping(value = "/V2/page")
//	public ResponseEntity<Page<Turma>> listarTurmasPorPaginacaoV2(
//			@RequestParam(value = "pagina", defaultValue = "0") int pagina,
//			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao,
//			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
//		Page<Turma> turmas = turmaService.buscarPorPaginacao(pagina, 5, direcao, orderBy);
//		return ResponseEntity.ok().body(turmas);
//	}

	@Operation(description = Messages.SWAGGER_GET_ONE)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Turma> buscaPorID(@PathVariable Integer id) throws ObjectNotFoundException {
		Turma turma = turmaService.buscaPorID(id);
		return ResponseEntity.ok().body(turma);
	}

	@Operation(description = Messages.SWAGGER_POST)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Turma turma) {
		Turma objTurma = turmaService.salvar(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objTurma.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(description = Messages.SWAGGER_PUT)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@PathVariable Integer id, @RequestBody Turma objTurma) {
		objTurma.setId(id);
		turmaService.alterar(objTurma);
		return ResponseEntity.noContent().build();
	}

	@Operation(description = Messages.SWAGGER_DELETE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		turmaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}