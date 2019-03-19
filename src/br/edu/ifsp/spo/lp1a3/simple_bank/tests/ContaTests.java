package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;

class ContaTests {

	
	@Test
	void deve_conseguir_criar_uma_classe_conta_com_titular_e_numero() {
		// 1. Configuração
		String titular = "João da Silva";
		String numeroConta = "001-002";
		
		// 2. Execução
		Conta conta = new Conta(titular, numeroConta);
		
		// 3. Validação / Asserção
		assertNotNull(conta);
		assertEquals(titular, conta.getTitular());
		assertEquals(numeroConta, conta.getNumeroConta());
	}
	
	@Test
	void uma_nova_conta_deve_ter_saldo_zero() {
		//1. Configuração
		Conta conta = new Conta("João da Silva", "123-456");
		
		//2. Execução
		double saldo = conta.getSaldo();
		
		//3. Validação / Asserção
		assertEquals(0, saldo);
	}
	
	@Test
	void devo_conseguir_depositar_um_valor_na_conta() {
		//1. Configuração
		Conta conta = new Conta("João da Silva", "123-456");
		double valorADepositar = 100;
		
		//2. Execução
		conta.depositar(valorADepositar);
		
		//3. Validação / Asserção
		assertEquals(valorADepositar, conta.getSaldo());
	}
	
	@Test
	void devo_conseguir_sacar_um_valor_na_conta() {
		//1. Configuração
		Conta conta = new Conta("João da Silva", "123-456");
		double valor = 10;
		
		//2. Execução
		conta.sacar(valor);
		
		//3. Validação / Asserção
		assertEquals(0-valor, conta.getSaldo());
		
	}
	
	@Test
	void devo_conseguir_transferir_um_valor_para_outra_conta() {
		//1. Configuração
		Conta conta = new Conta("João da Silva", "123-456");
		Conta outraConta = new Conta("José Simão", "789-456");
		double valor = 10;
		
		//2. Execução
		conta.transferirPara(outraConta, valor);
		
		//3. Validação / Asserção
		assertEquals (0-valor, conta.getSaldo());
		assertEquals (valor , outraConta.getSaldo());
	}
}
