package br.com.alura.loja.dao.impl;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao extends BaseDao<Categoria> {

    public CategoriaDao(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Categoria> getClasse() {
        return Categoria.class;
    }

    @Override
    protected String getNomeClasse() {
        return Categoria.class.getName();
    }
}







