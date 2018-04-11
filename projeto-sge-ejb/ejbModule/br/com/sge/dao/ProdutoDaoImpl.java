package br.com.sge.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.sge.domain.Produto;

/**
 * Session Bean implementation class ProdutoDaoImpl
 */
@Stateless
public class ProdutoDaoImpl extends AbstractDao<Produto> implements ProdutoDao {

    /**
     * Default constructor. 
     */
    public ProdutoDaoImpl() {
    	super(Produto.class);
        // TODO Auto-generated constructor stub
    }

	@Override
	public Integer sequencial() {
		// TODO Auto-generated method stub
		Integer seq = (Integer) em.createNamedQuery("Produto.sequencial").getSingleResult();
		return null;
	}

	

	

}
