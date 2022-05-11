package br.com.projetos.peter.financiasPeter.controller.dto;

import java.time.LocalDateTime;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;
import br.com.projetos.peter.financiasPeter.modelo.StatusFinancMesConta;

public class MonthFinanceAccountDto {
	
	private String dsFinanceMonthAccount;
	private Double vlFinanceMonthAccount;
	private StatusFinancMesConta flPayment;
	private LocalDateTime dtFinalPaymentDate;
	
	public MonthFinanceAccountDto (FinancMesConta financMesConta) {
		this.dsFinanceMonthAccount = financMesConta.getDsFinancMesConta();
		this.vlFinanceMonthAccount = financMesConta.getVlFinancMesConta();
		this.flPayment = financMesConta.getStatus();
		this.dtFinalPaymentDate = financMesConta.getDtVencimento();
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

	public StatusFinancMesConta getFlPayment() {
		return flPayment;
	}

	public void setFlPayment(StatusFinancMesConta flPayment) {
		this.flPayment = flPayment;
	}

	public LocalDateTime getDtFinalPaymentDate() {
		return dtFinalPaymentDate;
	}

	public void setDtFinalPaymentDate(LocalDateTime dtFinalPaymentDate) {
		this.dtFinalPaymentDate = dtFinalPaymentDate;
	}
}
