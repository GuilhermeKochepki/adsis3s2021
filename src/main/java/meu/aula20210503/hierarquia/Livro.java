package meu.aula20210503.hierarquia;

public class Livro extends Publicação {
	private int edição;

	public Livro(String título) {
		super(título);		//se refere ao título usado na superclasse
	}

	public Livro(String título, int edição) {
		super(título);
		this.edição = edição;
	}

	public void setEdição(int edição) {
		this.edição = edição;
	}

	public int getEdição() {
		return edição;
	}

}
