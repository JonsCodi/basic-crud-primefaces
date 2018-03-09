
package br.com.ntconsult.poc.sisnep.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.ntconsult.poc.sisnep.dao.AbastecimentoDAO;
import br.com.ntconsult.poc.sisnep.dao.VeiculoDAO;
import br.com.ntconsult.poc.sisnep.entidade.Veiculo;

@ManagedBean
@ViewScoped
public class AbastecimentoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String placa;
	private Veiculo SelectedVeiculo;
	private List<Veiculo> listaVeiculos;
	private Boolean disabled;
	
	@Inject
	public AbastecimentoDAO abastecimentoDAO;
	
	@Inject
	public VeiculoDAO veiculoDAO;
	
	@PostConstruct
	public void init() {
		setDisabled(true);
		setListaVeiculos(veiculoDAO.findAll());
	}
	
	public Veiculo getSelectedVeiculo() {
		return SelectedVeiculo;
	}
	
	public void setSelectedVeiculo(Veiculo selectedVeiculo) {
		SelectedVeiculo = selectedVeiculo;
	}
	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public Boolean getDisabled() {
		return disabled;
	}
	
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void add() {
		// TODO
		System.out.println(true);
	}
	
	// UTIL
	public List<String> completeText(String query) {
		List<String> results = new ArrayList<>();
		for(Veiculo veiculo : veiculoDAO.findWithPlaca(query))
			results.add(veiculo.getPlaca());
		return results;
	}
}
