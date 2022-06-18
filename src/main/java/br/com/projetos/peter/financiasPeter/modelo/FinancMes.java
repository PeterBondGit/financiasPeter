package br.com.projetos.peter.financiasPeter.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FinancMes {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinancMes;
	
	@ManyToOne
	private Usuario usuario;
	
	private String dsFinancMes;
	private String dsDetalhadaMes;
	private Double vlTotContasMes;
	
	@OneToMany(mappedBy = "financMes")
	private List<FinancMesConta> financMesContas;
	
	@OneToMany(mappedBy = "financMes")
	private List<FinancMesContaParc> financMesContaParcs;
	
	public FinancMes(String dsFinanceMonth, String dsDetailsMonth, Usuario usuario) {
		this.dsFinancMes = dsFinanceMonth;
		this.dsDetalhadaMes = dsDetailsMonth;
		this.usuario = usuario;
	}
	
	public FinancMes() {
	}

	public FinancMes(FinancMes financMes) {
		this.usuario = financMes.getUsuario();
		this.dsFinancMes = financMes.getDsFinancMes();
		this.dsDetalhadaMes = financMes.getDsDetalhadaMes();
		this.vlTotContasMes = financMes.getVlTotContasMes();
	}

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
	
	public List<FinancMesConta> getFinancMesContas() {
		return financMesContas;
	}

	public void setFinancMesContas(List<FinancMesConta> financMesContas) {
		this.financMesContas = financMesContas;
	}

	public List<FinancMesContaParc> getFinancMesContaParcs() {
		return financMesContaParcs;
	}

	public void setFinancMesContaParcs(List<FinancMesContaParc> financMesContaParcs) {
		this.financMesContaParcs = financMesContaParcs;
	}
	
}
