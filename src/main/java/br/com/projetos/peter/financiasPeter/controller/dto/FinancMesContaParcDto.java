package br.com.projetos.peter.financiasPeter.controller.dto;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

public class FinancMesContaParcDto {
	
	private String currentMonth;
	
	private String dsFinanceMonthAccountInstallment;
	
	private Double vlInstallment;	
	
	private Integer nrTotInstallmente;
	
	private Integer nrCurrentInstallment;

	public FinancMesContaParcDto(FinancMesContaParc financMesContaParc) {		
		this.currentMonth = financMesContaParc.getFinancMes().getDsFinancMes();
		this.dsFinanceMonthAccountInstallment = financMesContaParc.getDsFinancMesContaParc();
		this.vlInstallment = financMesContaParc.getVlParcela();
		this.nrTotInstallmente = financMesContaParc.getNrTotParcela();
		this.nrCurrentInstallment = financMesContaParc.getNrParcelaAtual();
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
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

	public Integer getNrTotInstallmente() {
		return nrTotInstallmente;
	}

	public void setNrTotInstallmente(Integer nrTotInstallmente) {
		this.nrTotInstallmente = nrTotInstallmente;
	}

	public Integer getNrCurrentInstallment() {
		return nrCurrentInstallment;
	}

	public void setNrCurrentInstallment(Integer nrCurrentInstallment) {
		this.nrCurrentInstallment = nrCurrentInstallment;
	}
}
