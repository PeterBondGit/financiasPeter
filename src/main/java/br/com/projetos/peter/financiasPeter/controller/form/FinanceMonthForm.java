package br.com.projetos.peter.financiasPeter.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetos.peter.financiasPeter.TokenService;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.UsuarioRepository;
import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.modelo.Usuario;

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

	public FinancMes converter(MonthFinanceRepository monthFinanceRepository, UsuarioRepository usuarioRepository, TokenService tokenService, String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = usuarioRepository.findById(idUsuario).get();

		FinancMes financMes = new FinancMes(dsFinanceMonth, dsDetailsMonth, usuario);
		return monthFinanceRepository.save(financMes);
	}
}
