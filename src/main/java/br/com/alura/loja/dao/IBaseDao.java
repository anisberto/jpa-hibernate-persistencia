package br.com.alura.loja.dao;

import java.util.List;

public interface IBaseDao<T> {
    void cadastrar(T object);
    void atualizar(T object);
    void remover(T object);
    T buscarPorId(Long id);
    List<T> buscarFiltrandoPorNome(String nome);
    String buscarTodos();
}
