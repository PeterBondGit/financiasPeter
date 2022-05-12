package br.com.projetos.peter.financiasPeter.controller.dto;

import br.com.projetos.peter.financiasPeter.modelo.FinancMes;

public class FinancMesDto {
	
	private Long idFinancMes;
	private String dsFinancMes;
	private String dsDetalhadaMes;
	
	public FinancMesDto (FinancMes financMes) {
		this.idFinancMes = financMes.getIdFinancMes();
		this.dsFinancMes = financMes.getDsFinancMes();
		this.dsDetalhadaMes = financMes.getDsDetalhadaMes();
	}

	public Long getIdFinancMes() {
		return idFinancMes;
	}

	public void setIdFinancMes(Long idFinancMes) {
		this.idFinancMes = idFinancMes;
	}

	public String getDsFinancMes() {
		return dsFinancMes;
	}

	public void setDsFinancMes(String dsFinancMes) {
		this.dsFinancMes = dsFinancMes;
	}

	public String getDsDetalhadaMes() {
		return dsDetalhadaMes;
	}

	public void setDsDetalhadaMes(String dsDetalhadaMes) {
		this.dsDetalhadaMes = dsDetalhadaMes;
	}
}
