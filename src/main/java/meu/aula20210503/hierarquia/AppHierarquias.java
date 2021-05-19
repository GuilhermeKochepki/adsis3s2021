package meu.aula20210503.hierarquia;

public class AppHierarquias {

	public static void main(String[] args) {
		Biblioteca unicesumarCentral = new Biblioteca();
		unicesumarCentral.adicionar(new Livro("Big Java 5a Edição"));
		unicesumarCentral.adicionar(new Livro("Big Java 5a Edição"));
		unicesumarCentral.adicionar(new Livro("Big Java 5a Edição"));
		unicesumarCentral.adicionar(new Livro("Big Java 5a Edição"));
		unicesumarCentral.adicionar(new Revista("Super Interessante ed. 33"));
		unicesumarCentral.adicionar(new Revista("Super Interessante ed. 33"));
		unicesumarCentral.adicionar(new Revista("Super Interessante ed. 33"));
		unicesumarCentral.adicionar(new Revista("Super Interessante ed. 33"));
		
	}
	
}
