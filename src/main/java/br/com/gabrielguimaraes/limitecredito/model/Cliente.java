package br.com.gabrielguimaraes.limitecredito.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -795277250510822260L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 5)
	private String nome;
	
	@NotNull
	private Double limiteCredito;
	
	@NotNull
	private RiscoInvestimento risco;
	
	@NotNull
	@Size(min = 5)
	private String endereco;
	
	private Double taxaJuros = Double.valueOf("0");
	
	/**
	 * Adicionar taxa de juros de acordo com o Risco escolhido
	 *
	 **/	
	public void calculaTaxaDeJuros() {
//		if (limiteCredito == null || limiteCredito.compareTo(BigDecimal.ZERO) < 1) {
//			return;
//		}
		if (risco == null) {
			return;
		}
		
//		this.taxaJuros = limiteCredito.add(
//				limiteCredito.multiply(
//						new BigDecimal(risco.getTaxaJuros()).divide(new BigDecimal("100"))
//				)
//		);
		this.taxaJuros = risco.getTaxaJuros();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public RiscoInvestimento getRisco() {
		return risco;
	}

	public void setRisco(RiscoInvestimento risco) {
		this.risco = risco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
