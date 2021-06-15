package meu.aula20210608.pessoa;

import meu.aula20210608.valueObjects.CNPJ;

public class PessoaJuridica extends Pessoa{
	private CNPJ cnpj;
	
	public PessoaJuridica(long id, String nome, CNPJ cnpj) {
		super(id, nome);
		this.cnpj = cnpj;
	}
	
	public CNPJ getCnpj() {
		return cnpj;
	}
}
