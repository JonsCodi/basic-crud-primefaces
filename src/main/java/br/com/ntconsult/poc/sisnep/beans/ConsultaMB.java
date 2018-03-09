
package br.com.ntconsult.poc.sisnep.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Persistence;

import org.primefaces.event.SelectEvent;

import br.com.ntconsult.poc.sisnep.cliente.Result;
import br.com.ntconsult.poc.sisnep.cliente.SinespClient;
import br.com.ntconsult.poc.sisnep.dao.VeiculoDAO;
import br.com.ntconsult.poc.sisnep.entidade.Categoria;
import br.com.ntconsult.poc.sisnep.entidade.Especie;
import br.com.ntconsult.poc.sisnep.entidade.Tracao;
import br.com.ntconsult.poc.sisnep.entidade.Veiculo;

@ManagedBean
@ViewScoped
public class ConsultaMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String placa;
	private String retorno;
	private String modelo;
	private boolean erro;
	private List<Result> retornoConsulta;
	private List<Veiculo> listaVeiculos;
	private List<Veiculo> filteredVeiculos;
	private Veiculo selectedVeiculo;
	private Boolean disabled;
	
	private Veiculo veiculo;
	private Integer cdTracao;
	private Integer cdEspecie;
	private Integer cdCategoria;
	
	private Tracao tracao;
	private Especie especie;
	private Categoria categoria;
	
	private List<Tracao> listaTracao;
	private List<Especie> listaEspecie;
	private List<Categoria> listaCategorias;
	
	@Inject
	private VeiculoDAO veiculoDAO;
	
	@Inject
	private SinespClient sinespClient;
	
	@PostConstruct
	public void init() {
		this.placa = "";
		this.retorno = "";
		this.modelo = "";
		this.erro = false;
		this.retornoConsulta = null;
		this.disabled = true;
		this.listaTracao = Arrays.asList(Tracao.values());
		this.listaEspecie = Arrays.asList(Especie.values());
		this.listaCategorias = Arrays.asList(Categoria.values());
		this.veiculo = new Veiculo();
		inicializaListaVeiculos();
	}
	
	public void inicializaListaVeiculos() {
		setListaVeiculos(veiculoDAO.findAll());
	}
	
	public void onRowSelect(SelectEvent event) {
		setDisabled(false);
	}
	
	public void onRowUnSelect() {
		setDisabled(true);
	}
	
	public void consultar() {
		this.retornoConsulta = new ArrayList<>();
		try {
			if (null != getVeiculo() && getVeiculo().getPlaca().isEmpty()) { return; }
			if (null != getVeiculo().getPlaca() && getVeiculo().getPlaca().contains("-")) {
				retorno = "Formato de placa inaváldo! Utilize o formato \"AAA9999\".";
				erro = true;
				this.retornoConsulta = null;
				return;
			}
			Result result = new Result();
			result = sinespClient.search(getVeiculo().getPlaca());
			if (null == result || (null != result && null == result.getPlate())) {
				retorno = "Dados não Encontrado";
				erro = true;
				this.retornoConsulta = null;
			} else retornoConsulta.add(result);
		} catch (RuntimeException e) {
			retorno = "Formato de placa inaváldo! Utilize o formato \"AAA9999\".";
			erro = true;
			this.retornoConsulta = null;
		}
		setaDadosRetoronoConsulta();
	}
	
	private void setaDadosRetoronoConsulta() {
		if (null != retornoConsulta && !retornoConsulta.isEmpty()) {
			getVeiculo().setModelo(retornoConsulta.get(0).getModel());
			getVeiculo().setAno(String.valueOf(retornoConsulta.get(0).getModelYear()));
			getVeiculo().setUf(retornoConsulta.get(0).getState());
		}
	}
	
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
	
	public void limpar() {
		placa = "";
		retorno = "";
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getRetorno() {
		return retorno;
	}
	
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
	public List<Result> getRetornoConsulta() {
		return retornoConsulta;
	}
	
	public void setRetornoConsulta(List<Result> retornoConsulta) {
		this.retornoConsulta = retornoConsulta;
	}
	
	public boolean isErro() {
		return erro;
	}
	
	public void setErro(boolean erro) {
		this.erro = erro;
	}
	
	public List<Tracao> getListaTracao() {
		return listaTracao;
	}
	
	public void setListaTracao(List<Tracao> listaTracao) {
		this.listaTracao = listaTracao;
	}
	
	public List<Especie> getListaEspecie() {
		return listaEspecie;
	}
	
	public void setListaEspecie(List<Especie> listaEspecie) {
		this.listaEspecie = listaEspecie;
	}
	
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	public Tracao getTracao() {
		return tracao;
	}
	
	public void setTracao(Tracao tracao) {
		this.tracao = tracao;
	}
	
	public Especie getEspecie() {
		return especie;
	}
	
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void montaTracaoVeiculo() {
		setTracao(Tracao.getTracao(getCdTracao()));
		getVeiculo().setTracao(getTracao());
	}
	
	public void montaEspecieVeiculo() {
		setEspecie(Especie.getEspecie(getCdEspecie()));
		getVeiculo().setEspecie(getEspecie());
	}
	
	public void montaCategoriaVeiculo() {
		setCategoria(Categoria.getCategoria(getCdCategoria()));
		getVeiculo().setCategoria(getCategoria());
	}
	
	public Integer getCdTracao() {
		return cdTracao;
	}
	
	public void setCdTracao(Integer cdTracao) {
		this.cdTracao = cdTracao;
	}
	
	public Integer getCdEspecie() {
		return cdEspecie;
	}
	
	public void setCdEspecie(Integer cdEspecie) {
		this.cdEspecie = cdEspecie;
	}
	
	public Integer getCdCategoria() {
		return cdCategoria;
	}
	
	public void setCdCategoria(Integer cdCategoria) {
		this.cdCategoria = cdCategoria;
	}
	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public List<Veiculo> getFilteredVeiculos() {
		return filteredVeiculos;
	}
	
	public void setFilteredVeiculos(List<Veiculo> filteredVeiculos) {
		this.filteredVeiculos = filteredVeiculos;
	}
	
	public Veiculo getSelectedVeiculo() {
		return selectedVeiculo;
	}
	
	public void setSelectedVeiculo(Veiculo selectedVeiculo) {
		this.selectedVeiculo = selectedVeiculo;
	}
	
	public Boolean getDisabled() {
		return disabled;
	}
	
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
	public void addVeiculo() {
		if (null != getVeiculo()) {
			veiculoDAO.add(getVeiculo());
		}
		this.refresh();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage("Sucesso", "Você cadastrou o veículo com a placa: ".concat(getVeiculo().getPlaca())));
	}
	
	public void editarVeiculo() {
		this.selectedVeiculo.setCategoria(getVeiculo().getCategoria());
		this.selectedVeiculo.setTracao(getVeiculo().getTracao());
		this.selectedVeiculo.setEspecie(getVeiculo().getEspecie());
		veiculoDAO.update(this.selectedVeiculo);
		this.refresh();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage("Sucesso", "Você atualizou o veículo com a placa: ".concat(this.selectedVeiculo.getPlaca())));
	}
	
	public void deleteVeiculo() {
		veiculoDAO.delete(this.selectedVeiculo);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso",
				"Você excluiu o veículo com a placa: ".concat(this.selectedVeiculo.getPlaca())));
		this.refresh();
		this.setDisabled(true);
	}
	
}
