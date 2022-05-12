package br.com.projetos.peter.financiasPeter.controller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projetos.peter.financiasPeter.modelo.FinancMes;

public interface MonthFinanceRepository extends JpaRepository<FinancMes, Long> {

	Optional<FinancMes> findByDsFinancMes(String currentMonth);
	
	@Query("SELECT t FROM FinancMes t WHERE t.dsFinancMes = :currentMonth")
	Optional<FinancMes> findByDsFinancMesPorQuery(String currentMonth);
	
}