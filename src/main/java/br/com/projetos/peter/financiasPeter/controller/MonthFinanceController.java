package br.com.projetos.peter.financiasPeter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetos.peter.financiasPeter.controller.dto.MonthFinanceDto;
import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.repository.MonthFinanceRepository;

@RestController
public class MonthFinanceController {
	
	@Autowired
	private MonthFinanceRepository monthFinanceRepository; 
	
	@RequestMapping("/monthFinance")
	public ResponseEntity<MonthFinanceDto> monthFinance(String currentMonth) {
		System.out.println("Entrou aqui");
		if ( currentMonth == null ) {
			return ResponseEntity.notFound().build();
		} else {
			Optional<FinancMes> financMes = monthFinanceRepository.findByDsFinancMes(currentMonth);
			if ( financMes.isPresent() ) {
				return ResponseEntity.ok(new MonthFinanceDto(financMes.get()));
			}
			return null;
		}
	}
}
