
package br.com.ntconsult.poc.sisnep.persistence;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author jonas.gomes
 *
 */
public class PersistenceManager {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	@PostConstruct
	private void init() {
		factory = Persistence.createEntityManagerFactory("sinesp");
		manager = factory.createEntityManager();
	}
	
	public EntityManager getManager() {
		return this.manager;
	}
	
	public void finalizaTransacao() {
		manager.getTransaction().commit();
	}
	
	public void iniciarTransacao() {
		manager.getTransaction().begin();
	}
	
	public void update(Object o) {
		iniciarTransacao();
		manager.merge(o);
		finalizaTransacao();
		manager.close();
	}
	
	public void persistir(Object o) {
		iniciarTransacao();
		manager.persist(o);
		finalizaTransacao();
		manager.close();
	}
	
	public void merge(Object o) {
		iniciarTransacao();
		manager.merge(o);
		finalizaTransacao();
		manager.close();
	}
	
	public void remove(Object o) {
		iniciarTransacao();
		manager.remove(o);
		finalizaTransacao();
		manager.close();
	}
}
