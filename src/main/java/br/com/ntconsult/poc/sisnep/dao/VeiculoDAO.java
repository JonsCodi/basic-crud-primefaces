
package br.com.ntconsult.poc.sisnep.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.ntconsult.poc.sisnep.entidade.Veiculo;
import br.com.ntconsult.poc.sisnep.persistence.PersistenceManager;

/**
 * 
 * @author jonas.gomes
 *
 */
public class VeiculoDAO extends PersistenceManager {
	
	public void add(Veiculo veiculo) {
		persistir(veiculo);
	}
	
	public void delete(Veiculo veiculo) {
		remove(veiculo);
	}
	
	public void update(Veiculo veiculo) {
		merge(veiculo);
	}
	
	public List<Veiculo> findAll() {
		TypedQuery<Veiculo> query = getManager().createNamedQuery("Veiculo.findAll", Veiculo.class);
		List<Veiculo> results = query.getResultList();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> findWithPlaca(String placa){
		return getManager().createQuery("SELECT v FROM Veiculo v WHERE v.placa LIKE :placaName", Veiculo.class).
				setParameter("placaName", "%".concat(placa).concat("%")).getResultList();
	}
	
}
