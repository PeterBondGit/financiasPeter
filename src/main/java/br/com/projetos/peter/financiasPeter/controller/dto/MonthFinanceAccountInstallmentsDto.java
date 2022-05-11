package br.com.projetos.peter.financiasPeter.controller.dto;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

public class MonthFinanceAccountInstallmentsDto {
	
	private String dsFinanceMonthAccountInstallment;
	private Double vlInstallment;
	private Integer nrTotInstallment;
	private Integer nrCurrenteInstallment;
	
	public MonthFinanceAccountInstallmentsDto (FinancMesContaParc financMesContaParc) {
		this.dsFinanceMonthAccountInstallment = financMesContaParc.getDsFinancMesContaParc();
		this.vlInstallment = financMesContaParc.getVlParcela();
		this.nrTotInstallment = financMesContaParc.getNrTotParcela();
		this.nrCurrenteInstallment = financMesContaParc.getNrParcelaAtual();
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
}
