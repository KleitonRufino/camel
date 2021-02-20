package camel;

import java.io.Serializable;

public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4188160701093732361L;
	private String nome;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
