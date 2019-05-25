package br.com.uol.test.repository;

import br.com.uol.test.model.Jogador;

import java.util.List;

public interface JogadorRepositoryCustom {
    List<String> buscaListaCodinome(String grupo);
    Jogador buscaPorNomeJogador(String nome);
}
