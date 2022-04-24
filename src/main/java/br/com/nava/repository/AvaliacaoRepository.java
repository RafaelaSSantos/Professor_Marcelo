package br.com.nava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.nava.entity.*;

@Repository
public interface AvaliacaoRepository extends JpaRepository <Avaliacao, AlunoDisciplina>{
	
	//SELECT * FROM avaliacao WHERE idAluno = 1 AND idDisciplina = 6;	
	Avaliacao findByAlunoDisciplina(AlunoDisciplina alunoDisciplina);
	
}