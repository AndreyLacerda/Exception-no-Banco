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
		if (titular == null || titular.trim().isEmpty()) {
			
			throw new TitularNullException("Titular não pode ser nulo ou vazio");
			
		}
		else {
			
			this.titular = titular;
			
			if ((numeroConta == null || numeroConta.trim().isEmpty())) {
				throw new NumeroContaException("Número da conta não pode ser nulo ou vazio");
			}
			else {
				this.numeroConta = numeroConta;
			}
		
		}

	}

	public double getSaldo() {
		return this.saldo;
	}

	public void depositar(double valor) { 
		this.saldo = this.saldo + valor;
	}
	
	public double sacar(double valor) {
		if (this.saldo == 0) {
			throw new SaldoZeroException("Saldo não pode ser igual a 0");
		}
		else {
			this.saldo = this.getSaldo() - valor;
			return this.getSaldo();
		}

	}
	
	public void transferirPara (Conta outraConta, double valor) {
		this.sacar(valor);
		outraConta.depositar(valor);
	}
}
