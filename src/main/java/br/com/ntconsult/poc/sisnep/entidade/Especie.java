package br.com.ntconsult.poc.sisnep.entidade;

public enum Especie {
	/**
	 * Referente ao tipo de passageiros
	 */
	PASSAGEIROS_BICICLETA(1, "Passageiros", "Bicicleta"), PASSAGEIROS_CICLOMOTOR(2, "Passageiros", "Ciclomotor"), PASSAGEIROS_MOTONETA(3, "Passageiros", "Motoneta"), PASSAGEIROS_MOTONCICLETA(4, "Passageiros", "Motocicleta"), PASSAGEIROS_TRICILO(5, "Passageiros", "Triciclo"), PASSAGEIROS_QUADRICICLO(6, "Passageiros", "Quadriciclo"), PASSAGEIROS_AUTOMOVEL(7, "Passageiros", "Automóvel"), PASSAGEIROS_MICROONIBUS(8, "Passageiros", "Microônibus"), PASSAGEIROS_ONIBUS(9, "Passageiros", "Ônibus"), PASSAGEIROS_BONDE(10, "Passageiros", "Bonde"), PASSAGEIROS_REBOQUE_SEMIREBOQUE(11, "Passageiros", "Reboque semi-reboque"), PASSAGEIROS_CHARRETE(12, "Passageiros", "Charrete"),

	/**
	 * Referente ao tipo de carga
	 */
	CARGA_MONTONETA(13, "Carga", "Motoneta"), CARGA_MOTOCICLETA(14, "Carga", "Motocicleta"), CARGA_TRICICLO(15, "Carga", "Triciclo"), CARGA_QUADRICICLO(16, "Carga", "Quadriciclo"), CARGA_CAMINHONETE(17, "Carga", "Caminhonete"), CARGA_CAMINHAO(18, "Carga", "Caminhão"), CARGA_REBOQUE_SEMIREBOQUE(19, "Carga", "Reboque semi-reboque"), CARGA_REBOQUE_CARROCA(20, "Carga", "Carroça"), CARGA_CARRODEMAO(21, "Carga", "Carro de Mão"),

	/**
	 * Referente ao tipo misto
	 */
	MISTO_CAMINHONETA(22, "Misto", "Caminhoneta"), MISTO_UTILITARIO(23, "Misto", "Utilitário"), MISTO_OUTROS(24, "Misto", "Outros"),

	COMPETICAO(25, "Competicao", "Competição"),

	TRACAO_CAMINHAO_TRATOR(26, "Tração", "Caminhão Trator"), TRACAO_TRATOR_RODAS(27, "Tração",
			"Trator de Rodas"), TRACAO_TRATOR_ESTEIRAS(28, "Tração",
					"Trator de Esteiras"), TRACAO_TRATOR_MISTO(29, "Tração", "Trator de Esteiras"),

	ESPECIAL(30, "Especial", "Especial"), COLECAO(31, "Coleção", "Especial");

	private String tipoEspecie;
	private String descricaoEspecie;
	private Integer codigoEspecie;

	private Especie(Integer codigoEspecie, String tipoEspecie, String descricaoEspecie) {
		this.codigoEspecie = codigoEspecie;
		this.tipoEspecie = tipoEspecie;
		this.descricaoEspecie = descricaoEspecie;
	}

	public String getTipoEspecie() {
		return tipoEspecie;
	}

	public void setTipoEspecie(String tipoEspecie) {
		this.tipoEspecie = tipoEspecie;
	}

	public String getDescricaoEspecie() {
		return descricaoEspecie;
	}

	public void setDescricaoEspecie(String descricaoEspecie) {
		this.descricaoEspecie = descricaoEspecie;
	}

	public Integer getCodigoEspecie() {
		return codigoEspecie;
	}

	public void setCodigoEspecie(Integer codigoEspecie) {
		this.codigoEspecie = codigoEspecie;
	}

	public static Especie getEspecie(Integer codigo) {
		for (Especie especie : values()) {
			if (especie.getCodigoEspecie() == codigo) {
				return especie;
			}
		}
		return null;
	}

}
