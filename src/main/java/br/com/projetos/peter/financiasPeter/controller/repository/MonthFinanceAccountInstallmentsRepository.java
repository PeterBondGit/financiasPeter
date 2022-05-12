package br.com.projetos.peter.financiasPeter.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesContaParc;

public interface MonthFinanceAccountInstallmentsRepository extends JpaRepository<FinancMesContaParc, Long> {

}
