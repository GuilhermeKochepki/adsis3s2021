package meu.aula20210503.hierarquia;

public class AppHierarquias {
	
	public static void main(String[] args) {
		Biblioteca unicesumarCentral = new Biblioteca();
		unicesumarCentral.adicionar(new Livro("Big Java", 5));
		unicesumarCentral.adicionar(new Livro("Big Java", 5));
		unicesumarCentral.adicionar(new Livro("Big Java", 5));
		unicesumarCentral.adicionar(new Livro("Big Java", 5));
		
		unicesumarCentral.adicionar(new Revista("Super Interessante",33));
		unicesumarCentral.adicionar(new Revista("Super Interessante",33));
		unicesumarCentral.adicionar(new Revista("Super Interessante",34));
		unicesumarCentral.adicionar(new Revista("Super Interessante",35));
		
		
		for (Publicação p : unicesumarCentral.getAcervo()) {		//Para cada publicação P que eu tenho no acervo, p é uma publicação específica
			if (p instanceof Livro) {	//Se publicação for um livro...
				//coerção de tipos (type casting)
				Livro aux1 = (Livro) p;		//Joga o livro em um auxiliar do tipo Livro, transformando a publicação em um tipo Livro
				System.out.println(aux1.getTítulo() + ". Edição N° " + aux1.getEdição());
			} else if (p instanceof Revista) {
				Revista aux2 = (Revista) p;		//Joga a revista em um auxiliar do tipo Revista, transformando a publicação em um tipo Revista
				System.out.println(aux2.getTítulo() + ". Número: " + aux2.getNúmero());
			} else {
				System.out.println(p.getTítulo());	
			}
		}
		
		
	}

}
