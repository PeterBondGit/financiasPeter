package br.com.projetos.peter.financiasPeter.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FinancMesContaParc {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinancMesContaParc;
	
	@ManyToOne
	private FinancMes financMes;
	
	private String dsFinancMesContaParc;
	private Double vlParcela;
	private Integer nrTotParcela;
	private Integer nrParcelaAtual;
	
	public FinancMesContaParc (FinancMes financMes2, String dsFinanceMonthAccountInstallment, 
			Double vlInstallment, Integer nrTotInstallment, Integer nrCurrenteInstallment) {
		
		this.financMes = financMes2;
		this.dsFinancMesContaParc = dsFinanceMonthAccountInstallment;
		this.vlParcela = vlInstallment;
		this.nrTotParcela = nrTotInstallment;
		this.nrParcelaAtual = nrCurrenteInstallment;
		
	}
	
	public FinancMesContaParc () {}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFinancMesContaParc == null) ? 0 : idFinancMesContaParc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancMesContaParc other = (FinancMesContaParc) obj;
		if (idFinancMesContaParc == null) {
			if (other.idFinancMesContaParc != null)
				return false;
		} else if (!idFinancMesContaParc.equals(other.idFinancMesContaParc))
			return false;
		return true;
	}

	public Long getIdFinancMesContaParc() {
		return idFinancMesContaParc;
	}

	public void setIdFinancMesContaParc(Long idFinancMesContaParc) {
		this.idFinancMesContaParc = idFinancMesContaParc;
	}

	public FinancMes getFinancMes() {
		return financMes;
	}

	public void setFinancMes(FinancMes financMes) {
		this.financMes = financMes;
	}

	public String getDsFinancMesContaParc() {
		return dsFinancMesContaParc;
	}

	public void setDsFinancMesContaParc(String dsFinancMesContaParc) {
		this.dsFinancMesContaParc = dsFinancMesContaParc;
	}

	public Double getVlParcela() {
		return vlParcela;
	}

	public void setVlParcela(Double vlParcela) {
		this.vlParcela = vlParcela;
	}

	public Integer getNrTotParcela() {
		return nrTotParcela;
	}

	public void setNrTotParcela(Integer nrTotParcela) {
		this.nrTotParcela = nrTotParcela;
	}

	public Integer getNrParcelaAtual() {
		return nrParcelaAtual;
	}

	public void setNrParcelaAtual(Integer nrParcelaAtual) {
		this.nrParcelaAtual = nrParcelaAtual;
	}
}
