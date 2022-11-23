package br.com.valhalla.ohwaiter.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.valhalla.ohwaiter.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

    @Query(value = "SELECT p FROM Prato p WHERE p.id IN :ids")
    List<Prato> findByIdList(@Param("ids") Collection<Long> ids);

}
