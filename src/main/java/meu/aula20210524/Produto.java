package meu.aula20210524;

public class Produto {
	private int código;
	private String marca;
	private String modelo;
	private int quantidade;
	
	public Produto(int código, String marca, String modelo, int quantidade) {
		this.código = código;
		this.marca = marca;
		this.modelo = modelo;
		this.quantidade = quantidade;
	}

	public int getCódigo() {
		return código;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
}
