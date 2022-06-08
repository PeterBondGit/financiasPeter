package br.com.projetos.peter.financiasPeter.controller.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projetos.peter.financiasPeter.controller.dto.FinancMesContaDto;
import br.com.projetos.peter.financiasPeter.controller.dto.FinancMesContaParcDto;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceAccountInstallmentsRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceAccountRepository;
import br.com.projetos.peter.financiasPeter.controller.repository.MonthFinanceRepository;
import br.com.projetos.peter.financiasPeter.modelo.FinancMes;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;
import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

public class FinancMonthService {

	public List<FinancMesConta> generateAccount(FinancMes financMes, List<FinancMesConta> listFinancMesContas) {
		List<FinancMesContaDto> financMesContaDtos = listFinancMesContas.stream().map(ac -> new FinancMesContaDto(ac)).collect(Collectors.toList());
		
		return financMesContaDtos.stream().map(dto -> new FinancMesConta(financMes, dto.getDsFinanceMonthAccount(), dto.getVlFinanceMonthAccount(), dto.getDtFinalPaymentDate()))
				.collect(Collectors.toList());
	}

	public List<FinancMesContaParc> generateAccountParcs(FinancMes financMes, List<FinancMesContaParc> listFinancMesContasParc) {
		List<FinancMesContaParcDto> financMesContaParcDtos = listFinancMesContasParc.stream().map(ac -> new FinancMesContaParcDto(ac, true)).collect(Collectors.toList());
		
		return financMesContaParcDtos.stream().map(dto -> new FinancMesContaParc(financMes, dto.getDsFinanceMonthAccountInstallment(), 
				dto.getVlInstallment(), dto.getNrTotInstallmente(), dto.getNrCurrentInstallment())).collect(Collectors.toList());
	}

	public FinancMes montarNovoMes(FinancMes financMes, MonthFinanceRepository monthFinanceRepository,
			MonthFinanceAccountRepository monthFinanceAccountRepository,
			MonthFinanceAccountInstallmentsRepository monthFinanceAccountInstallmentsRepository) {
		
		FinancMes financMesNew = new FinancMes(financMes);
		monthFinanceRepository.save(financMesNew);

		List<FinancMesConta> listFinancMesContasNew = generateAccount(financMesNew, financMes.getFinancMesContas());
		monthFinanceAccountRepository.saveAll(listFinancMesContasNew);

		List<FinancMesContaParc> listFinancMesContasParcNew = generateAccountParcs(financMesNew, financMes.getFinancMesContaParcs().stream().filter(cp -> cp.getNrParcelaAtual() < cp.getNrTotParcela()).collect(Collectors.toList()));
		monthFinanceAccountInstallmentsRepository.saveAll(listFinancMesContasParcNew);
		
		return financMes;
	}
}
