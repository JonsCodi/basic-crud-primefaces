package br.com.ntconsult.poc.sisnep.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author everton.moura
 */
@Entity
@Table(name = "VEICULOS")
@NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PLACA")
	private String placa;
	@Column(name = "MODELO")
	private String modelo;
	@Column(name = "ANO")
	private String ano;
	@Column(name = "UF")
	private String uf;
	@Column(name = "CATEGORIA")
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	@Column(name = "ESPECIE")
	@Enumerated(EnumType.ORDINAL)
	private Especie especie;
	@Column(name = "TRACAO")
	@Enumerated(EnumType.ORDINAL)
	private Tracao tracao;

	public Veiculo() {
		super();
	}
	
	
	public Veiculo(String placa, String modelo, String ano, String uf, Categoria categoria, Especie especie,
			Tracao tracao) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.uf = uf;
		this.categoria = categoria;
		this.especie = especie;
		this.tracao = tracao;
	}




	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Especie getEspecie() {
		return especie;
	}


	public void setEspecie(Especie especie) {
		this.especie = especie;
	}


	public Tracao getTracao() {
		return tracao;
	}


	public void setTracao(Tracao tracao) {
		this.tracao = tracao;
	}

}
