package br.com.sge.manageBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.sge.dao.ProdutoDao;
import br.com.sge.domain.Produto;

@ManagedBean(name="produtomb")
@RequestScoped
public class ProdutoMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2524083082474121406L;

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
		produtos = pdao.listar();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String novo() {				
		produto.setIdproduto(pdao.sequencial());
		return "pro";
	}		
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			pdao.inserir(produto);	
			context.addMessage(null, new FacesMessage("Sucesso",  produto.getDescricao()+" cadastrado com sucesso!"));
			return "pro";
		} catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("Falha ao inserir o produto, mensagem de erro: "+e.getMessage() );
			 context.addMessage(null, new FacesMessage("Falha",  e.getMessage()));
			 return "index";
		}
	}

}
