package br.com.projetos.peter.financiasPeter.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

public class AccountFinishMonthDto {

	private String returnDesc; 

	private List<MonthFinanceAccountInstallmentsDto> listAcoountInstallments;
	
	public AccountFinishMonthDto(String returnDesc, List<FinancMesContaParc> listAcoountInstallments) {
		this.returnDesc = returnDesc;
		this.listAcoountInstallments = converterToDto(listAcoountInstallments);
	}

	private List<MonthFinanceAccountInstallmentsDto> converterToDto(List<FinancMesContaParc> listAcoountInstallments) {
		return listAcoountInstallments.stream().map(ac -> new MonthFinanceAccountInstallmentsDto(ac)).collect(Collectors.toList());
	}

	public String getReturnDesc() {
		return returnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}

	public List<MonthFinanceAccountInstallmentsDto> getListAcoountInstallments() {
		return listAcoountInstallments;
	}

	public void setListAcoountInstallments(List<MonthFinanceAccountInstallmentsDto> listAcoountInstallments) {
		this.listAcoountInstallments = listAcoountInstallments;
	}
}
