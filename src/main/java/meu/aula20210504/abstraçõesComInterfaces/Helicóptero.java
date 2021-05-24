package meu.aula20210504.abstraçõesComInterfaces;

public class Helicóptero implements CoisaQueVoa, CoisaQueCai {

	public void voar() {
		System.out.println("Helicóptero voando");
	}
	
	public void cair() {
		System.out.println("Mei dei Mei dei. Bluft");
	}
	
}
