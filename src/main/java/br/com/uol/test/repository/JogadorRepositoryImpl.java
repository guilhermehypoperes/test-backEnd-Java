package br.com.uol.test.repository;

import br.com.uol.test.model.Jogador;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class JogadorRepositoryImpl implements JogadorRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> buscaListaCodinome(String grupo) {
        try {
            String jpql = "select j.codinome from Jogador j where j.grupo = :grupo";
            Query query = em.createQuery(jpql);
            query.setParameter("grupo",grupo);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<String>();
        }
    }

    @Override
    public Jogador buscaPorNomeJogador(String nome){
        try {
            String jpql = "select j from Jogador j where j.nome = :nome";
            Query query = em.createQuery(jpql);
            query.setParameter("nome",nome);
            return (Jogador) query.getResultList().get(0);
        } catch (NoResultException e) {
            return new Jogador();
        }
    }
}
