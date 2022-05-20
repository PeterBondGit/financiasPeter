package br.com.projetos.peter.financiasPeter.controller.dto;

public class AccountMaxMonthDto {
	
	private String messageClient;
	
	private Double vlMaxAccount;

	public AccountMaxMonthDto(String messageClient, Double vlMaxAccount) {
		this.messageClient = messageClient;
		this.vlMaxAccount = vlMaxAccount;
	}

	public String getMessageClient() {
		return messageClient;
	}

	public void setMessageClient(String messageClient) {
		this.messageClient = messageClient;
	}

	public Double getVlMaxAccount() {
		return vlMaxAccount;
	}

	public void setVlMaxAccount(Double vlMaxAccount) {
		this.vlMaxAccount = vlMaxAccount;
	}
}
