
package br.com.ntconsult.poc.sisnep.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jonas.gomes
 */
@Entity
@Table(name = "ABASTECIMENTOS")
@NamedQuery(name = "Abastecimento.findAll", query = "SELECT a FROM Abastecimento a")
public class Abastecimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "PLACA")
	private String placa;
	@Column(name="orgao")
	private String orgao;
	@Column(name="produto")
	private String produto;
	@Column(name="hodometro")
	private long hodometro;
	@Column(name="quantidade")
	private double quantidade;
	@Column(name="valor")
	private double valor;
	@Column(name = "dateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	@Column(name="dataPostagem")
	@Temporal(TemporalType.DATE)
	private Date dataPostagem;
	@Column(name="fornecedor")
	private long fornecedor;
	
	public Abastecimento() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
