package meu.aula20210503.hierarquia;

import java.util.Date;

public class Revista {
	private String título;
	private Date publicadoEm;
	private int número;
	
	public Revista(String título) {
		this.título = título;
	} 
	
	public Revista(String título, Date publicadoEm) {
		this.título = título;
		this.publicadoEm = publicadoEm;
	}
	
	public String getTítulo() {
		return título;
	}
	
	public Date getPublicadoEm() {
		return publicadoEm;
	}
	
	public int getNúmero() {
		return número;
	}
	
	public void setNúmero(int número) {
		this.número = número;
	}
	
}
