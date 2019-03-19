package br.edu.ifsp.spo.lp1a3.simple_bank;

public class Conta {
	
	private String titular;
	private String numeroConta;
	private double saldo;
	
	public String getTitular() {
		return this.titular;
	}
	
	public String getNumeroConta() {
		return this.numeroConta;
	}
	
	public Conta(String titular, String numeroConta) {
		this.titular = titular;
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void depositar(double valor) { 
		this.saldo = this.saldo + valor;
	}
	
	public double sacar(double valor) {
		this.saldo = this.getSaldo() - valor;
		return this.getSaldo();
	}
	
	public void transferirPara (Conta outraConta, double valor) {
		this.sacar(valor);
		outraConta.depositar(valor);
	}
}
