package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.ContaCorrente;

public class ContaCorrenteTeste {
	
	@Test
	void deve_conseguir_criar_uma_classe_conta_corrente_com_titular_numero_e_limite() {
		// 1. Configuração
		String titular = "Joaquim Gonzaga";
		String numeroConta = "111-222";
		double limite = 50;
		
		// 2. Execução
		ContaCorrente corrente = new ContaCorrente(titular, numeroConta, limite);
		
		// 3. Validação / Asserção
		assertNotNull(corrente);
		assertEquals(titular, corrente.getTitular());
		assertEquals(numeroConta, corrente.getNumeroConta());
		assertEquals(limite, corrente.getLimiteChequeEspecial());
	}

	@Test
	void deve_conseguir_debitar_juros_da_conta_corrente () {
		// 1. Configuração
		String titular = "José Gonzaga";
		String numeroConta = "222-333";
		double limite = 50;
		
		// 2. Execução
		ContaCorrente corrente = new ContaCorrente(titular, numeroConta, limite);
		corrente.setTaxaJurosChequeEspecia(0.13);
		corrente.depositar(800);
		double saldo = corrente.getSaldo();
		corrente.debitarJuros();
		double juros = saldo * corrente.getTaxaJurosChequeEspecial();
		juros = juros + juros * 0.01;
		
		// 3. Validação / Asserção
		assertEquals(saldo - juros, corrente.getSaldo());
		
	}
}
