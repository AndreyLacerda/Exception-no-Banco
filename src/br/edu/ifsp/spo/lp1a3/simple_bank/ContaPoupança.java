package br.edu.ifsp.spo.lp1a3.simple_bank;

public class ContaPoupança extends Conta{
	
	public ContaPoupança(String titular, String numeroConta) {
		super(titular, numeroConta);
	}

	private static double taxaRendimento = 0.085;

	public static double getTaxaRendimento() {
		return taxaRendimento;
	}

	public static void setTaxaRendimento(double taxaRendimento) {
		if (taxaRendimento <= 0) {
			throw new RendimentoMenorZeroException("Rendimento não pode ser igual a 0");
		}
		else {
			ContaPoupança.taxaRendimento = taxaRendimento;
		}
	}
	
	public void aplicarRendimento() {
		double valor = this.getSaldo() * getTaxaRendimento();
		this.depositar(valor);
	}
}
