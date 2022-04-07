package br.com.nava.resource;

import java.net.URI;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.nava.entity.Turma;
import br.com.nava.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {	
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Turma>> listarTurmas(){
		List<Turma> turmas = turmaService.listaTodasTurmas();		
		return ResponseEntity.ok().body(turmas);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Turma> buscaPorID(@PathVariable Integer id) throws ObjectNotFoundException{
		Turma turma = turmaService.buscaPorID(id);
		return ResponseEntity.ok().body(turma);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Turma turma){
		Turma objTurma = turmaService.salvar(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objTurma.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@PathVariable Integer id, @RequestBody Turma objTurma){
		objTurma.setId(id);
		turmaService.alterar(objTurma);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		turmaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}