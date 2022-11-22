package br.com.valhalla.ohwaiter.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.valhalla.ohwaiter.model.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {

    @Query(value = "SELECT m FROM Mesa m WHERE m.id IN :ids")
    List<Mesa> findByIdList(@Param("ids") Collection<Long> ids);

}
