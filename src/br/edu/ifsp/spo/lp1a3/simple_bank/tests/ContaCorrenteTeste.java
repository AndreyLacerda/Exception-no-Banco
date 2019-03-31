package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.ContaCorrente;
import br.edu.ifsp.spo.lp1a3.simple_bank.LimiteMenorZeroException;
import br.edu.ifsp.spo.lp1a3.simple_bank.SaldoZeroException;

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
	
	@Test
	void exception_deve_ser_disparada_caso_saque_com_saldo_0() {
		//1. Configuração
		ContaCorrente corrente = new ContaCorrente("João da Silva", "123-456", 10);
		double valor = 10;
		
		//2. Validação / Asserção
		try {
			corrente.sacar(valor);
		}
		catch (SaldoZeroException s){
			
		}
		
	}
	
	@Test
	void exception_deve_ser_disparada_caso_limite_menor_que_0() {
		//1. Configuração
		String nome = "Junior";
		String numero = "126851";
		double limite = -1;
		
		//2. Validação / Asserção
		try {
			ContaCorrente corrente = new ContaCorrente(nome, numero, limite);
		}
		catch (LimiteMenorZeroException l){
			
		}
		
	}
}
