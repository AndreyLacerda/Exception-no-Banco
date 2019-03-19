package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.ContaPoupan�a;

public class ContaPoupan�aTeste {
	
	@Test
	void deve_conseguir_setar_taxa() {
		// 1. Configura��o
		String titular = "Joaquim Gonzaga";
		String numeroConta = "111-222";
		
		//2. Execu��o
		ContaPoupan�a poupan�a = new ContaPoupan�a(titular, numeroConta);
		poupan�a.setTaxaRendimento(0.085);
		
		//3. Valida��o / Asser��o
		assertEquals(0.085, poupan�a.getTaxaRendimento());
	}
	
	@Test
	void deve_conseguir_aplicar_rendimento_poupan�a() {
		// 1. Configura��o
		String titular = "Joaquim Gonzaga";
		String numeroConta = "111-222";
		
		//2. Execu��o
		ContaPoupan�a poupan�a = new ContaPoupan�a(titular, numeroConta);
		poupan�a.setTaxaRendimento(0.085);
		poupan�a.depositar(800);
		poupan�a.aplicarRendimento();
		
		//3. Valida��o / Asser��o
		assertEquals(800+(800*0.085), poupan�a.getSaldo());
	}

}
