package meu.aula20210503.conjuntos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppConjuntos {

		public static void main(String[] args) {
			String nome = "Arthur Cattaneo ZAvadski Jr";
			System.out.println(nome.hashCode());
			
			List<Integer> listaDeInteiros = new ArrayList<>();	//Lista
			listaDeInteiros.add(100);
			listaDeInteiros.add(50);
			listaDeInteiros.add(50);
			listaDeInteiros.add(2);
			
			Set<Integer> conjuntoDeInteiros = new HashSet<>();	//Conjunto
			conjuntoDeInteiros.add(100);
			conjuntoDeInteiros.add(50);
			conjuntoDeInteiros.add(50);
			conjuntoDeInteiros.add(2);
			
			listarColeção(">>> List", listaDeInteiros);
			listarColeção(">>> Set", conjuntoDeInteiros);
			
		}
			public static void listarColeção(String mensagem, Collection<? extends Object> coleção) {
				System.out.println(mensagem);
				for (Object elemento : coleção) {
					System.out.println(elemento);
				}
				System.out.println("----------------");
			}
			
	
}
