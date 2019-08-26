package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.forum.controller.dto.AtualizarTopicoForm;
import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCursoNome(String nomeCurso);

	@Query("SELECT a FROM Topico a WHERE a.curso.nome = ?1")
	List<Topico> buscarPorNomeCurso(String nomeCurso);

}
