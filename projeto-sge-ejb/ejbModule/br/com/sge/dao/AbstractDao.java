package br.com.sge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


public class AbstractDao<T> {
	
	@PersistenceContext(unitName="projeto-sge-ejb-pu")	
	protected EntityManager em;
	
	private Class<T> entityClass;

	public AbstractDao(Class<T> entityClass) {		
		this.entityClass = entityClass;
	}
	
	public void inserir(T obj) {
		em.persist(obj);
	}
	public void alterar(T obj) {
		em.merge(obj);
	}
	public void excluir(T obj) {
		em.remove(obj);
	}
	public T obterPorId(Integer id) {
		return em.find(entityClass, id);
	}
	
	public List<T> listar() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));		
		return em.createQuery(cq).getResultList();
	}
	

}
