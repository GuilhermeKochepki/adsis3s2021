package meu.aula20210503.hierarquia;

import java.util.ArrayList;
import java.util.List;

import aula20210503.hierarquias.Publicação;

public class Biblioteca {
	private List<Publicação> acervo = new ArrayList<>();
	
	public void adicionar(Publicação nova) {
		System.out.println("Adicionando uma nova publicação ao acervo! " + nova.getTítulo() );
		acervo.add(nova);
	}
	
	public List<Publicação> getAcervo() {
		return acervo;
	}

}