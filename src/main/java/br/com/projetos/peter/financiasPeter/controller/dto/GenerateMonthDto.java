package br.com.projetos.peter.financiasPeter.controller.dto;

public class GenerateMonthDto {
	
	public String messageReturn;
	
	public String nameMonthAccount;

	public GenerateMonthDto(String messageReturn, String nameMonthAccount) {
		this.messageReturn = messageReturn;
		this.nameMonthAccount = nameMonthAccount;
	}

	public String getMessageReturn() {
		return messageReturn;
	}

	public void setMessageReturn(String messageReturn) {
		this.messageReturn = messageReturn;
	}

	public String getNameMonthAccount() {
		return nameMonthAccount;
	}

	public void setNameMonthAccount(String nameMonthAccount) {
		this.nameMonthAccount = nameMonthAccount;
	}
}
