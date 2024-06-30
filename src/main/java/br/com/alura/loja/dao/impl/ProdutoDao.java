package br.com.alura.loja.dao.impl;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao extends BaseDao<Produto> {

    public ProdutoDao(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Produto> getClasse() {
        return Produto.class;
    }

    @Override
    protected String getNomeClasse() {
        return Produto.class.getName();
    }

    public List<Produto> buscarFiltrandoPorNomeCategoria(String nome) {
        String jpql = "SELECT t FROM " + getNomeClasse() + " t WHERE t.categoria.nome = :nome";
        return em.createQuery(jpql, getClasse()).setParameter("nome", nome).getResultList();
    }
}
