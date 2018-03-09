package br.com.ntconsult.poc.sisnep.entidade;

public enum Tracao {

	AUTOMOTOR(1, "Automotor"), ELETRICO(2, "Elétrico"), PROPULSAO_HUMANA(3, "Propulsão Humana"), ANIMAL(4,
			"Tração Animal"), REBOQUE_SEMIREBOQUE(5, "Reboque ou semi-reboque");

	private String descricaoTracao;
	private Integer codigoTracao;

	private Tracao(Integer codigoTracao, String descricaoTracao) {
		this.codigoTracao = codigoTracao;
		this.descricaoTracao = descricaoTracao;
	}

	public String getDescricaoTracao() {
		return descricaoTracao;
	}

	public void setDescricaoTracao(String descricaoTracao) {
		this.descricaoTracao = descricaoTracao;
	}

	public Integer getCodigoTracao() {
		return codigoTracao;
	}

	public void setCodigoTracao(Integer codigoTracao) {
		this.codigoTracao = codigoTracao;
	}

	public static Tracao getTracao(Integer codigo) {
		for (Tracao tracao : values()) {
			if (tracao.getCodigoTracao() == codigo) {
				return tracao;
			}
		}
		return null;
	}
}
