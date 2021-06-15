package meu.aula20210608.valueObjects;

public abstract class ValueObject {
	public String valor;
	
	public ValueObject(String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	};
}
