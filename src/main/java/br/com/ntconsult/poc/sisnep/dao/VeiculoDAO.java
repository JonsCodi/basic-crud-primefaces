
package br.com.ntconsult.poc.sisnep.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.ntconsult.poc.sisnep.entidade.Veiculo;

@Named
public class VeiculoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	@PostConstruct
	private void init() {
		factory = Persistence.createEntityManagerFactory("sinesp");
		manager = factory.createEntityManager();
	}
	
	/**
	 * Consulta todos veiculos cadastrados
	 * 
	 * @return lista de veiculos
	 */
	public List<Veiculo> consultarTodosVeiculos() {
		TypedQuery<Veiculo> query = manager.createNamedQuery("Veiculo.findAll", Veiculo.class);
		List<Veiculo> results = query.getResultList();
		return results;
		
	}
	
	/**
	 * FIXME apenas teste
	 * 
	 * @return Veiculo
	 */
	public Veiculo teste() {
		Veiculo veiculo = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sinesp");
			EntityManager manager = factory.createEntityManager();
			veiculo = new Veiculo();
			veiculo.setPlaca("INA7412");
			veiculo.setAno("2007");
			veiculo.setModelo("HONDA FIT");
			manager.getTransaction().begin();
			manager.persist(veiculo);
			manager.getTransaction().commit();
			
			TypedQuery<Veiculo> query = manager.createNamedQuery("Veiculo.findAll", Veiculo.class);
			@SuppressWarnings("unused")
			List<Veiculo> results = query.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return veiculo;
	}
	
	public Veiculo add(Veiculo veiculo) {
		if (null != veiculo) {
			// lançar uma exc. campos obrigatorios
		}
		manager.getTransaction().begin();
		manager.persist(veiculo);
		manager.getTransaction().commit();
		manager.close();
		return veiculo;
	}

	public void delete(Veiculo veiculo) {
		manager.getTransaction().begin();
		manager.remove(veiculo);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void update(Veiculo veiculo) {
		manager.getTransaction().begin();
		manager.merge(veiculo);
		manager.getTransaction().commit();
		manager.close();
	}

}
