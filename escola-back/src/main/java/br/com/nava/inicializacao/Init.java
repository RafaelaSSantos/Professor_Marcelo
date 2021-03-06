package br.com.nava.inicializacao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import br.com.nava.entity.*;
import br.com.nava.repository.AlunoRepository;
import br.com.nava.service.*;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Juca");		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Marcia");		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Janaina");	
//		
//		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
//		
//		Turma cc = new Turma();
//		cc.setNome("Ciencia da computação");		
//	    Turma ads = new Turma();
//	    ads.setNome("ADS");	   
//	    Turma rede = new Turma();
//	    rede.setNome("Rede");
//	    
//	    turmaService.salvar(cc);
//	    turmaService.salvar(ads);
//	    turmaService.salvar(rede);
	    
//	    //teste para ver no cosole
//	    List<Turma> listaTurmas = turmaService.listaTodasTurmas();	    
//	    for(Turma console: listaTurmas) {
//	    		System.out.println("Nome da turma: " + console.getNome());
//	    }
//	    
//	    //teste para verificar se esta trazendo turma por id
//	    Turma buscaID = turmaService.buscaPorID(2);
//	    System.out.println(buscaID.getNome());	    
	    
	    //teste para excluir por id
	    //turmaService.excluir(1);
	    
	    //teste para ver no cosole
//	    List<Turma> listaTurmas = turmaService.listaTodasTurmas();	    
//	    for(Turma console: listaTurmas) {
//	    		System.out.println("Nome da turma: " + console.getNome());
//	    }
	    
	    //teste para alterar turma
//	    Turma alterarID = new Turma();
//	    alterarID.setId(3);
//	    alterarID.setNome("Redes");
//	    
//	    turmaService.alterar(alterarID);
	    
//	    //teste para ver no cosole
//	    List<Turma> listaTurmas = turmaService.listaTodasTurmas();	    
//	    for(Turma console: listaTurmas) {
//	    		System.out.println("Nome da turma: " + console.getNome());
//	    }
	    
//	    
//	    Disciplina java = new Disciplina();
//	    java.setNome("Java");
//	    Disciplina php = new Disciplina();
//	    php.setNome("php");	    
//	    disciplinaService.salvar(java);
//	    disciplinaService.salvar(php);
		
		/*para aula da parte 4*/	    
//	    Turma nuvem = new Turma();
//	    nuvem.setNome("Nuvem");
//	    turmaService.salvar(nuvem);
//	    Turma contabel = new Turma();
//	    contabel.setNome("Contabilidade");
//	    turmaService.salvar(contabel);
//	    
//	    aluno1.setTurma(contabel);
//	    aluno2.setTurma(nuvem);
//	    aluno3.setTurma(nuvem);
//	    
//	    alunoRepository.save(aluno1);
//	    alunoRepository.save(aluno2);
//	    alunoRepository.save(aluno3);
//	    
//	    Disciplina java = new Disciplina();
//	    java.setNome("Java");
//	    Disciplina php = new Disciplina();
//	    php.setNome("php");
//	    Disciplina csharp = new Disciplina();
//	    csharp.setNome("C#"); 
//	    disciplinaService.salvar(java);
//	    disciplinaService.salvar(php);
//	    disciplinaService.salvar(csharp);
//	    aluno1.setDisciplinas(Arrays.asList(java, php));
//	    aluno2.setDisciplinas(Arrays.asList(java, csharp));
//	    aluno3.setDisciplinas(Arrays.asList(php, csharp)); 
//	    
//	    alunoRepository.save(aluno1);
//	    alunoRepository.save(aluno2);
//	    alunoRepository.save(aluno3);
//		
//		Avaliacao ava1 = new Avaliacao();
//		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
//		alunoDisciplina.setAluno(aluno1);
//		alunoDisciplina.setDisciplina(java);				
//		ava1.setAlunoDisciplina(alunoDisciplina);
//		ava1.setConceito("A");		
//		avaliacaoService.save(ava1);		
//		
//		Avaliacao ava2 = new Avaliacao();
//		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
//		alunoDisciplina2.setAluno(aluno2);			
//		alunoDisciplina2.setDisciplina(csharp);	
//		ava2.setAlunoDisciplina(alunoDisciplina2);
//		ava2.setConceito("C");		
//		avaliacaoService.save(ava2);		
//		
//		Avaliacao ava3 = new Avaliacao();
//		AlunoDisciplina alunoDisciplina3 = new AlunoDisciplina();
//		alunoDisciplina3.setAluno(aluno3);
//		alunoDisciplina3.setDisciplina(php);				
//		ava3.setAlunoDisciplina(alunoDisciplina3);
//		ava3.setConceito("B");	
//		avaliacaoService.save(ava3);
//		
		
		
	}
}