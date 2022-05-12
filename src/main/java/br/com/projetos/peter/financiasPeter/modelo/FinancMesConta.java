package br.com.projetos.peter.financiasPeter.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FinancMesConta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinancMesConta;
	
	@ManyToOne
	private FinancMes financMes;
	
	private String dsFinancMesConta;
	private Double vlFinancMesConta;
	
	@Enumerated(EnumType.STRING)
	private StatusFinancMesConta status = StatusFinancMesConta.NAO_PAGO;
	
	private LocalDateTime dtVencimento;
	
	public FinancMesConta(FinancMes financMes, String dsAccountMonth, Double vlAccountMonth, LocalDateTime dtFinalPaymentDate) {
		this.financMes = financMes;
		this.dsFinancMesConta = dsAccountMonth;
		this.vlFinancMesConta = vlAccountMonth;
		this.dtVencimento = dtFinalPaymentDate; 
	}
	
	public FinancMesConta() {	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFinancMesConta == null) ? 0 : idFinancMesConta.hashCode());
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
		FinancMesConta other = (FinancMesConta) obj;
		if (idFinancMesConta == null) {
			if (other.idFinancMesConta != null)
				return false;
		} else if (!idFinancMesConta.equals(other.idFinancMesConta))
			return false;
		return true;
	}

	public Long getIdFinancMesConta() {
		return idFinancMesConta;
	}

	public void setIdFinancMesConta(Long idFinancMesConta) {
		this.idFinancMesConta = idFinancMesConta;
	}

	public FinancMes getFinancMes() {
		return financMes;
	}

	public void setFinancMes(FinancMes financMes) {
		this.financMes = financMes;
	}

	public String getDsFinancMesConta() {
		return dsFinancMesConta;
	}

	public void setDsFinancMesConta(String dsFinancMesConta) {
		this.dsFinancMesConta = dsFinancMesConta;
	}

	public Double getVlFinancMesConta() {
		return vlFinancMesConta;
	}

	public void setVlFinancMesConta(Double vlFinancMesConta) {
		this.vlFinancMesConta = vlFinancMesConta;
	}

	public StatusFinancMesConta getStatus() {
		return status;
	}

	public void setStatus(StatusFinancMesConta status) {
		this.status = status;
	}

	public LocalDateTime getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(LocalDateTime dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
}
