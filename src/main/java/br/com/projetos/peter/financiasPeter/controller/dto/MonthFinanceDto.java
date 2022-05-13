package br.com.projetos.peter.financiasPeter.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.projetos.peter.financiasPeter.modelo.FinancMes;

public class MonthFinanceDto {
	
	private Long idUser;
	private String nmUser;
	private String dsEmail;
	private Long nrTelephone;
	private String profile;
	private String dsFinanceMonth;
	private String dsDetailsMonth;
	private Double vlTotMonth;
	private List<MonthFinanceAccountDto> listAcoount;
	private List<MonthFinanceAccountInstallmentsDto> listAcoountInstallments;

	public MonthFinanceDto(FinancMes financMes) {
		if ( financMes.getUsuario() != null ) {
			this.idUser = financMes.getUsuario().getIdUsuario();
			this.nmUser = financMes.getUsuario().getNmUsuario();
			this.dsEmail = financMes.getUsuario().getDsEmail();
			this.nrTelephone = financMes.getUsuario().getNrTelefone();
		}
		this.profile = null;
		this.dsFinanceMonth = financMes.getDsFinancMes();
		this.dsDetailsMonth = financMes.getDsDetalhadaMes();
		this.listAcoount = new ArrayList<>();
		this.listAcoount.addAll(financMes.getFinancMesContas().stream().map(MonthFinanceAccountDto::new).collect(Collectors.toList()));
		this.listAcoountInstallments = new ArrayList<>();
		this.listAcoountInstallments.addAll(financMes.getFinancMesContaParcs().stream().map(MonthFinanceAccountInstallmentsDto::new).collect(Collectors.toList()));
		//
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNmUser() {
		return nmUser;
	}

	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public Long getNrTelephone() {
		return nrTelephone;
	}

	public void setNrTelephone(Long nrTelephone) {
		this.nrTelephone = nrTelephone;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDsFinanceMonth() {
		return dsFinanceMonth;
	}

	public void setDsFinanceMonth(String dsFinanceMonth) {
		this.dsFinanceMonth = dsFinanceMonth;
	}

	public String getDsDetailsMonth() {
		return dsDetailsMonth;
	}

	public void setDsDetailsMonth(String dsDetailsMonth) {
		this.dsDetailsMonth = dsDetailsMonth;
	}

	public List<MonthFinanceAccountDto> getListAcoount() {
		return listAcoount;
	}

	public void setListAcoount(List<MonthFinanceAccountDto> listAcoount) {
		this.listAcoount = listAcoount;
	}

	public List<MonthFinanceAccountInstallmentsDto> getListAcoountInstallments() {
		return listAcoountInstallments;
	}

	public void setListAcoountInstallments(List<MonthFinanceAccountInstallmentsDto> listAcoountInstallments) {
		this.listAcoountInstallments = listAcoountInstallments;
	}

	public Double getVlTotMonth() {
		return vlTotMonth;
	}

	public void setVlTotMonth(Double vlTotMonth) {
		this.vlTotMonth = vlTotMonth;
	}
}
