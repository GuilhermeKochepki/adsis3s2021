package meu.aula20210608.pessoa;

import meu.aula20210608.valueObjects.CPF;

public class PessoaFisica extends Pessoa{
	private CPF cpf;
	
	public PessoaFisica(long id, String nome, CPF cpf) {
		super(id, nome);
		this.cpf = cpf;
	}
	
	public CPF getCpf() {
		return cpf;
	}
}
