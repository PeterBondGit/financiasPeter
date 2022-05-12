package br.com.projetos.peter.financiasPeter.controller.form;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceAccountRepository;
import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;
import br.com.projetos.peter.financiasPeter.repository.MonthFinanceRepository;

public class AccountMonthForm {
	
	@NotNull @NotEmpty
	private String currentMonth;
	
	@NotNull @NotEmpty
	private String dsAccountMonth;
	
	private Double vlAccountMonth;
	
	@NotNull @NotEmpty
	private String dtFinalPaymentDate;
	
	public AccountMonthForm(String currentMonth, String dsAccountMonth, Double vlAccountMonth, String dtFinalPaymentDate) {
		this.currentMonth = currentMonth;
		this.dsAccountMonth = dsAccountMonth;
		this.vlAccountMonth = vlAccountMonth;
		this.dtFinalPaymentDate = dtFinalPaymentDate;
	}

	public String getDsAccountMonth() {
		return dsAccountMonth;
	}

	public Double getVlAccountMonth() {
		return vlAccountMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public void setDsAccountMonth(String dsAccountMonth) {
		this.dsAccountMonth = dsAccountMonth;
	}

	public void setVlAccountMonth(Double vlAccountMonth) {
		this.vlAccountMonth = vlAccountMonth;
	}

	public String getDtFinalPaymentDate() {
		return dtFinalPaymentDate;
	}

	public void setDtFinalPaymentDate(String dtFinalPaymentDate) {
		this.dtFinalPaymentDate = dtFinalPaymentDate;
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public FinancMesConta converter(MonthFinanceAccountRepository monthFinanceAccountRepository, MonthFinanceRepository monthFinanceRepository) {
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("dd/MM/uuuu").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
		LocalDateTime dtFinalPaymentDateFormated = LocalDate.parse(dtFinalPaymentDate, parser).atStartOfDay();
		
		Optional<FinancMes> financMes = monthFinanceRepository.findByDsFinancMes(currentMonth);
		FinancMesConta financMesConta = new FinancMesConta(financMes.get(), dsAccountMonth, vlAccountMonth, dtFinalPaymentDateFormated);
		
		return monthFinanceAccountRepository.save(financMesConta);
	}
}
