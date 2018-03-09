package br.com.ntconsult.poc.sisnep.entidade;

public enum Categoria {

	OFICIAL(1, "Oficial"), DIPLOMATICA(2,
			"Representação diplomática, de repartições consulares de carreira ou organismos internacionais acreditados junto ao Governo brasileiro"), PARTICULAR(
					3, "Particular"), ALUGUEL(4, "Aluguel"), APRENDIZAGEM(5, "Aprendizagem");

	private String descricaoCategoria;
	private Integer codigoCategoria;
	private boolean editable;

	private Categoria(Integer codigoCategoria, String descricaoCategoria) {
		this.codigoCategoria = codigoCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public static Categoria getCategoria(Integer codigo) {
		for (Categoria categoria : values()) {
			if (categoria.getCodigoCategoria() == codigo) {
				return categoria;
			}
		}
		return null;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
