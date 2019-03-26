package br.edu.ifsp.spo.lp1a3.simple_bank;

public class ContaCorrente extends Conta {

	private double limiteChequeEspecial;
	private static double taxaJurosChequeEspecial = 0.13;
	
	public ContaCorrente(String titular, String numeroConta, double limite) {
		super(titular, numeroConta);
		if (limite < 0) {
			throw new LimiteMenorZeroException("Limite não pode ser menor que 0");
		}
		else {
			this.limiteChequeEspecial = limite;
		}
	}
	
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}
	public static double getTaxaJurosChequeEspecial() {
		return taxaJurosChequeEspecial;
	}
	public static void setTaxaJurosChequeEspecia(double taxaJurosChequeEspecial) {
		ContaCorrente.taxaJurosChequeEspecial = taxaJurosChequeEspecial;
	}
	
	public void debitarJuros() {
		double juros = this.getSaldo() * getTaxaJurosChequeEspecial();
		this.sacar(juros);
	}
	
	@Override
	public double sacar(double valor) {
		
		if (this.getSaldo() == 0) {
			throw new SaldoZeroException("Saldo não pode ser igual a 0");
		}
		else {
			valor = valor + (valor * 0.01);
			super.sacar(valor);
			return this.getSaldo();
		}

	}
}