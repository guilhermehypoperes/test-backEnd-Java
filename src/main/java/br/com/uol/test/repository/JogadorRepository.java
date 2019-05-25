package br.com.uol.test.repository;

import br.com.uol.test.model.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends  CrudRepository<Jogador,Long>,JogadorRepositoryCustom{}
