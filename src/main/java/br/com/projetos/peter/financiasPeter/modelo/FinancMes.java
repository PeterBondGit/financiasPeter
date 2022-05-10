package br.com.projetos.peter.financiasPeter.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FinancMes {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinancMes;
	@ManyToOne
	private Usuario usuario;
	private String dsFinancMes;
	private String dsDetalhadaMes;
	private Double vlTotContasMes;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFinancMes == null) ? 0 : idFinancMes.hashCode());
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
		FinancMes other = (FinancMes) obj;
		if (idFinancMes == null) {
			if (other.idFinancMes != null)
				return false;
		} else if (!idFinancMes.equals(other.idFinancMes))
			return false;
		return true;
	}

	public Long getIdFinancMes() {
		return idFinancMes;
	}

	public void setIdFinancMes(Long idFinancMes) {
		this.idFinancMes = idFinancMes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Double getVlTotContasMes() {
		return vlTotContasMes;
	}

	public void setVlTotContasMes(Double vlTotContasMes) {
		this.vlTotContasMes = vlTotContasMes;
	}
}
