package meu.aula20210504.abstraçõesComInterfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		List<CoisaQueVoa> coisas = criarCoisasQueVoam();	
		for (CoisaQueVoa coisa : coisas) {
			coisa.voar();
			if (coisa instanceof CoisaQueCai) {
				CoisaQueCai aux = (CoisaQueCai) coisa;
				aux.cair();
			}
		}
	}
	
	public static List<CoisaQueVoa> criarCoisasQueVoam() {
		return Arrays.asList(
				new Coruja(), 
				new Coruja(), 
				new Helicóptero());
	}

}
