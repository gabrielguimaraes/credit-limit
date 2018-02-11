package br.com.gabrielguimaraes.limitecredito.model;

public enum RiscoInvestimento {
	A(0.00), B(10.00), C(20.00);
	
	private double taxaJuros;

	private RiscoInvestimento(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}
}
