package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.NumeroContaException;
import br.edu.ifsp.spo.lp1a3.simple_bank.SaldoZeroException;
import br.edu.ifsp.spo.lp1a3.simple_bank.TitularNullException;

class ContaTests {

	
	@Test
	void deve_conseguir_criar_uma_classe_conta_com_titular_e_numero() {
		// 1. Configura��o
		String titular = "Jo�o da Silva";
		String numeroConta = "001-002";
		
		// 2. Execu��o
		Conta conta = new Conta(titular, numeroConta);
		
		// 3. Valida��o / Asser��o
		assertNotNull(conta);
		assertEquals(titular, conta.getTitular());
		assertEquals(numeroConta, conta.getNumeroConta());
	}
	
	@Test
	void uma_nova_conta_deve_ter_saldo_zero() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		
		//2. Execu��o
		double saldo = conta.getSaldo();
		
		//3. Valida��o / Asser��o
		assertEquals(0, saldo);
	}
	
	@Test
	void devo_conseguir_depositar_um_valor_na_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		double valorADepositar = 100;
		
		//2. Execu��o
		conta.depositar(valorADepositar);
		
		//3. Valida��o / Asser��o
		assertEquals(valorADepositar, conta.getSaldo());
	}
	
	@Test
	void devo_conseguir_sacar_um_valor_na_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		double valor = 10;
		
		//2. Execu��o
		conta.depositar(valor);
		conta.sacar(valor);
		
		//3. Valida��o / Asser��o
		assertEquals(0, conta.getSaldo());
		
	}
	
	@Test
	void devo_conseguir_transferir_um_valor_para_outra_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		Conta outraConta = new Conta("Jos� Sim�o", "789-456");
		double valor = 10;
		
		//2. Execu��o
		conta.depositar(valor);
		conta.transferirPara(outraConta, valor);
		
		//3. Valida��o / Asser��o
		assertEquals (0, conta.getSaldo());
		assertEquals (valor , outraConta.getSaldo());
	}
	
	@Test
	void exception_deve_ser_disparada_caso_titular_seja_invalido() {
		//1. Configura��o
		String nome = null;
		String numero = "123-456";
		
		//2. Valida��o / Asser��o
		try {
			Conta conta = new Conta(nome, numero);
		}
		catch (TitularNullException t) {
			
		}
	}
	
	@Test
	void exception_deve_ser_disparada_caso_Numero_seja_invalido() {
		//1. Configura��o
		String nome = "Carlos";
		String numero = null;
		
		//2. Valida��o / Asser��o
		try {
			Conta conta = new Conta(nome, numero);
		}
		catch (NumeroContaException n) {
			
		}
	}
	
	@Test
	void exception_deve_ser_disparada_caso_saque_com_saldo_0() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		double valor = 10;
		
		//2. Valida��o / Asser��o
		try {
			conta.sacar(valor);
		}
		catch (SaldoZeroException s){
			
		}
		
	}
}
