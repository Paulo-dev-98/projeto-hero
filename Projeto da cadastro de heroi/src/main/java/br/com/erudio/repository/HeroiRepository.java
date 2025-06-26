package br.com.erudio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.erudio.data.model.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long>{
	
	@Query("SELECT h FROM Heroi h WHERE h.nome LIKE LOWER(CONCAT ('%', :nome, '%'))")
	Page<Heroi> findHeroiByNome(@Param("nome") String nome, Pageable pageable);

}
