package br.com.valhalla.ohwaiter.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.valhalla.ohwaiter.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
    
    @Query(value = "SELECT e FROM Estoque e WHERE e.nome IN :nomes")
    List<Estoque> findByNomeList(@Param("nomes") Collection<String> nomes);

}
