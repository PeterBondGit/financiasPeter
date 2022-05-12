package br.com.projetos.peter.financiasPeter.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetos.peter.financiasPeter.modelo.FinancMesConta;

public interface MonthFinanceAccountRepository extends JpaRepository<FinancMesConta, Long> {

}
