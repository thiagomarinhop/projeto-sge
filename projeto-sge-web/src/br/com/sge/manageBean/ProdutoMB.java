package br.com.sge.manageBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sge.dao.ProdutoDao;
import br.com.sge.domain.Produto;

@ManagedBean
@RequestScoped
public class ProdutoMB {
	
	@EJB
	private ProdutoDao pdao;
	
	private Produto produto;
	private Produto produtoSelected;
	private List<Produto> produtos;
	
	public ProdutoMB() {		
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdutoSelected() {
		return produtoSelected;
	}

	public void setProdutoSelected(Produto produtoSelected) {
		this.produtoSelected = produtoSelected;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String novo() {
		produto.setIdproduto(pdao.sequencial());
		return "cad_produto";
	}		

}
