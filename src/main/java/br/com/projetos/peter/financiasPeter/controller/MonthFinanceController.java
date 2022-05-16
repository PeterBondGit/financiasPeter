package br.com.projetos.peter.financiasPeter.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projetos.peter.financiasPeter.TokenService;
import br.com.projetos.peter.financiasPeter.controller.dto.FinancMesContaDto;
import br.com.projetos.peter.financiasPeter.controller.dto.FinancMesContaParcDto;
import br.com.projetos.peter.financiasPeter.controller.dto.FinancMesDto;
import br.com.projetos.peter.financiasPeter.controller.dto.MonthFinanceDto;
import br.com.projetos.peter.financiasPeter.controller.form.AccountInstallmentMonthForm;
import br.com.projetos.peter.financiasPeter.controller.form.AccountMonthForm;
import br.com.projetos.peter.financiasPeter.controller.form.FinanceMonthForm;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceAccountInstallmentsRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceAccountRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.UsuarioRepository;
import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

@RestController
@RequestMapping("/monthFinance")
public class MonthFinanceController {
	
	@Autowired
	private MonthFinanceRepository monthFinanceRepository; 

	@Autowired
	private MonthFinanceAccountRepository monthFinanceAccountRepository; 

	@Autowired
	private MonthFinanceAccountInstallmentsRepository monthFinanceAccountInstallmentsRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/{currentMonth}")
	@Cacheable(value = "ContasMes")
	public ResponseEntity<MonthFinanceDto> monthFinance(@PathVariable String currentMonth) {
		System.out.println("Entrou aqui");
		if ( currentMonth == null ) {
			return ResponseEntity.notFound().build();
		} else {
			Optional<FinancMes> financMes = monthFinanceRepository.findByDsFinancMes(currentMonth);
			if ( financMes.isPresent() ) {
				return ResponseEntity.ok(new MonthFinanceDto(financMes.get()));
			}
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@CacheEvict(value = "ContasMes", allEntries = true)
	public ResponseEntity<FinancMesDto> registerFinanceMonth (@RequestBody @Valid FinanceMonthForm form, UriComponentsBuilder uriBuilder, @RequestHeader("Authorization") String authorizationHeader ) {
		String token = recuperarToken(authorizationHeader);
		FinancMes financMes = form.converter(monthFinanceRepository, usuarioRepository, tokenService, token);
		
		URI uri = uriBuilder.path("/monthFinance/{currentMonth}").buildAndExpand(financMes.getDsFinancMes()).toUri();
		return ResponseEntity.created(uri).body(new FinancMesDto(financMes)); 
	}
	
	private String recuperarToken(String authorizationHeader) {
		return authorizationHeader.substring(7, authorizationHeader.length());
	}

	@PostMapping
	@RequestMapping("/registerAccountInstallmentMonth")
	@CacheEvict(value = "ContasMes", allEntries = true)
	public ResponseEntity<FinancMesContaParcDto> registerAccountInstallmentMonth (@RequestBody @Valid AccountInstallmentMonthForm form, UriComponentsBuilder uriBuilder ) {
		FinancMesContaParc financMesContaParc = form.converter(monthFinanceAccountInstallmentsRepository, monthFinanceRepository);
		
		URI uri = uriBuilder.path("/monthFinance/{currentMonth}").buildAndExpand(financMesContaParc.getFinancMes().getDsFinancMes()).toUri();
		return ResponseEntity.created(uri).body(new FinancMesContaParcDto(financMesContaParc));
	}
	
	@PostMapping
	@RequestMapping("/registerAccountMonth")
	@CacheEvict(value = "ContasMes", allEntries = true)
	public ResponseEntity<FinancMesContaDto> registerAccountMonth (@RequestBody @Valid AccountMonthForm form, UriComponentsBuilder uriBuilder ) {
		FinancMesConta financMesConta = form.converter(monthFinanceAccountRepository, monthFinanceRepository);
		
		URI uri = uriBuilder.path("/monthFinance/{currentMonth}").buildAndExpand(financMesConta.getFinancMes().getDsFinancMes()).toUri();
		return ResponseEntity.created(uri).body(new FinancMesContaDto(financMesConta));
	}
}
