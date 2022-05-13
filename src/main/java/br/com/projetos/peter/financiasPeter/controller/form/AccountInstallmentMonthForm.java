package br.com.projetos.peter.financiasPeter.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceAccountInstallmentsRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceRepository;
import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

public class AccountInstallmentMonthForm {
	
	@NotNull @NotEmpty
	private String currentMonth;
	
	@NotNull @NotEmpty
	private String dsFinanceMonthAccountInstallment;
	
	@NotNull 
	private Double vlInstallment;
	
	@NotNull 
	private Integer nrTotInstallment;
	
	@NotNull 
	private Integer nrCurrenteInstallment;

	public AccountInstallmentMonthForm(String currentMonth, String dsFinanceMonthAccountInstallment, Double vlInstallment,
			Integer nrTotInstallment, Integer nrCurrenteInstallment) {

		this.currentMonth = currentMonth;
		this.dsFinanceMonthAccountInstallment = dsFinanceMonthAccountInstallment;
		this.vlInstallment = vlInstallment;
		this.nrTotInstallment = nrTotInstallment;
		this.nrCurrenteInstallment = nrCurrenteInstallment;
	}

	public String getDsFinanceMonthAccountInstallment() {
		return dsFinanceMonthAccountInstallment;
	}

	public void setDsFinanceMonthAccountInstallment(String dsFinanceMonthAccountInstallment) {
		this.dsFinanceMonthAccountInstallment = dsFinanceMonthAccountInstallment;
	}

	public Double getVlInstallment() {
		return vlInstallment;
	}

	public void setVlInstallment(Double vlInstallment) {
		this.vlInstallment = vlInstallment;
	}

	public Integer getNrTotInstallment() {
		return nrTotInstallment;
	}

	public void setNrTotInstallment(Integer nrTotInstallment) {
		this.nrTotInstallment = nrTotInstallment;
	}

	public Integer getNrCurrenteInstallment() {
		return nrCurrenteInstallment;
	}

	public void setNrCurrenteInstallment(Integer nrCurrenteInstallment) {
		this.nrCurrenteInstallment = nrCurrenteInstallment;
	}

	public FinancMesContaParc converter(
			MonthFinanceAccountInstallmentsRepository monthFinanceAccountInstallmentsRepository,
			MonthFinanceRepository monthFinanceRepository) {

		Optional<FinancMes> financMes = monthFinanceRepository.findByDsFinancMes(currentMonth);
		FinancMesContaParc financMesContaParc = new FinancMesContaParc(financMes.get(), dsFinanceMonthAccountInstallment, vlInstallment, nrTotInstallment, nrCurrenteInstallment);
		
		return monthFinanceAccountInstallmentsRepository.save(financMesContaParc);
	}
}
