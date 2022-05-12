package br.com.projetos.peter.financiasPeter.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.repository.MonthFinanceRepository;

public class FinanceMonthForm {
	
	@NotNull @NotEmpty
	private String dsFinanceMonth;
	
	@NotNull @NotEmpty
	private String dsDetailsMonth;
	
	public void setDsFinanceMonth(String dsFinanceMonth) {
		this.dsFinanceMonth = dsFinanceMonth;
	}

	public void setDsDetailsMonth(String dsDetailsMonth) {
		this.dsDetailsMonth = dsDetailsMonth;
	}

	public FinancMes converter(MonthFinanceRepository monthFinanceRepository) {
		FinancMes financMes = new FinancMes(dsFinanceMonth, dsDetailsMonth);
		return monthFinanceRepository.save(financMes);
	}
}
