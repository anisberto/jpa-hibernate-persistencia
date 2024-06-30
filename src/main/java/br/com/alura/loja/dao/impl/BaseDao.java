package br.com.alura.loja.dao.impl;

import br.com.alura.loja.dao.IBaseDao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseDao<T> implements IBaseDao<T> {

    protected final EntityManager em;

    public BaseDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(T t) {
        this.em.persist(t);
    }

    public void atualizar(T t) {
        this.em.merge(t);
    }



    public void remover(T t) {
        t = this.em.merge(t);
        this.em.remove(t);
    }

    public T buscarPorId(Long id) {
        return this.em.find(getClasse(), id);
    }

    public String buscarTodos() {
        String jpql = "SELECT t FROM " + getNomeClasse() + " t";
        return em.createQuery(jpql, getClasse()).getResultList().toString();
    }

    public List<T> buscarFiltrandoPorNome( String nome) {
        String jpql = "SELECT t FROM " + getNomeClasse() + " t WHERE t.nome = :nome";
        return em.createQuery(jpql, getClasse()).setParameter("nome", nome).getResultList();
    }

    protected abstract Class<T> getClasse();

    protected abstract String getNomeClasse();
}
