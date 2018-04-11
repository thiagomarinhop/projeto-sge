package br.com.sge.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.sge.domain.Produto;

@Local
public interface ProdutoDao {
	
	public void inserir(Produto p);
	public void alterar(Produto p);
	public void excluir(Produto p);
	public Produto obterPorId(Integer id);
	public List<Produto> listar();
	public Integer sequencial();

}
