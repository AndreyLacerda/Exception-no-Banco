package br.edu.ifsp.spo.lp1a3.simple_bank;

public class LimiteMenorZeroException extends RuntimeException{
	
	public LimiteMenorZeroException() {
		
	}
	
	public LimiteMenorZeroException(String msg) {	
		super(msg);
	
	}

}
