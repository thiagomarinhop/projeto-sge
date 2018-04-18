package br.com.sge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Produto.sequencial", query="select coalesce(max(p.idproduto),0)+1 from Produto p")
public class Produto {
	
	private Integer idproduto;
	private String  descricao;
	
	@Id
	@Column
	public Integer getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}
	
	@Column(name="nome")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idproduto == null) ? 0 : idproduto.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idproduto == null) {
			if (other.idproduto != null)
				return false;
		} else if (!idproduto.equals(other.idproduto))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Produto [idproduto=" + idproduto + ", descricao=" + descricao + "]";
	}
	
	
	
	 
	

}
