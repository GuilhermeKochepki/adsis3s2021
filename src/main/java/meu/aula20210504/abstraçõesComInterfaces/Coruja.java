package meu.aula20210504.abstraçõesComInterfaces;

public class Coruja implements CoisaQueVoa, CoisaQueCai {

	public void voar() {
		System.out.println("Coruja voando");
	}
	
	public void cair() {
		System.out.println("Bluuft");
	}
	
}
