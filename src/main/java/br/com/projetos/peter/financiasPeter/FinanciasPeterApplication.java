package br.com.projetos.peter.financiasPeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FinanciasPeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanciasPeterApplication.class, args);
		System.out.println("Começando Projeto Financeiro do Peter");
	}

}
