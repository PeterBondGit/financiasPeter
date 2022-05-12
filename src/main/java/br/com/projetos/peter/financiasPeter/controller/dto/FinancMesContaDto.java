package br.com.projetos.peter.financiasPeter.controller.dto;

import java.time.LocalDateTime;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;

public class FinancMesContaDto {
	
	private String currentMonth;
	
	private String dsFinanceMonthAccount;
	
	private Double vlFinanceMonthAccount;
	
	private LocalDateTime dtFinalPaymentDate;

	public FinancMesContaDto(FinancMesConta financMesConta) {
		this.currentMonth = financMesConta.getFinancMes().getDsFinancMes();
		this.dsFinanceMonthAccount = financMesConta.getDsFinancMesConta();
		this.vlFinanceMonthAccount = financMesConta.getVlFinancMesConta();
		this.dtFinalPaymentDate = financMesConta.getDtVencimento();
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public String getDsFinanceMonthAccount() {
		return dsFinanceMonthAccount;
	}

	public void setDsFinanceMonthAccount(String dsFinanceMonthAccount) {
		this.dsFinanceMonthAccount = dsFinanceMonthAccount;
	}

	public Double getVlFinanceMonthAccount() {
		return vlFinanceMonthAccount;
	}

	public void setVlFinanceMonthAccount(Double vlFinanceMonthAccount) {
		this.vlFinanceMonthAccount = vlFinanceMonthAccount;
	}

	public LocalDateTime getDtFinalPaymentDate() {
		return dtFinalPaymentDate;
	}

	public void setDtFinalPaymentDate(LocalDateTime dtFinalPaymentDate) {
		this.dtFinalPaymentDate = dtFinalPaymentDate;
	}
}
