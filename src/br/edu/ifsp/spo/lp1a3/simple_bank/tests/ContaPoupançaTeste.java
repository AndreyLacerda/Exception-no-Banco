package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.ContaPoupança;

public class ContaPoupançaTeste {
	
	@Test
	void deve_conseguir_setar_taxa() {
		// 1. Configuração
		String titular = "Joaquim Gonzaga";
		String numeroConta = "111-222";
		
		//2. Execução
		ContaPoupança poupança = new ContaPoupança(titular, numeroConta);
		poupança.setTaxaRendimento(0.085);
		
		//3. Validação / Asserção
		assertEquals(0.085, poupança.getTaxaRendimento());
	}
	
	@Test
	void deve_conseguir_aplicar_rendimento_poupança() {
		// 1. Configuração
		String titular = "Joaquim Gonzaga";
		String numeroConta = "111-222";
		
		//2. Execução
		ContaPoupança poupança = new ContaPoupança(titular, numeroConta);
		poupança.setTaxaRendimento(0.085);
		poupança.depositar(800);
		poupança.aplicarRendimento();
		
		//3. Validação / Asserção
		assertEquals(800+(800*0.085), poupança.getSaldo());
	}

}
