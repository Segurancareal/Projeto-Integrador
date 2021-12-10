package org.generation.segurancareal.repository;


import java.util.List;

import org.generation.segurancareal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	public List<Tema> findAllByHashtagContainingIgnoreCase(String hashtag);
	public List<Tema> findAllByAssuntoContainingIgnoreCase(String assunto);
	

}
