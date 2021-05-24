package meu.aula20210503.hierarquia;

public class Revista extends Publicação{
	private int número;
	
	public Revista(String título) {
		super(título);
	} 
	
	public Revista(String título, int número) {
		super(título);
		this.número = número;
		//this.publicadoEm = publicadoEm;
	}
	
	public int getNúmero() {
		return número;
	}
	public void setNúmero(int número) {
		this.número = número;
	}
	
}
