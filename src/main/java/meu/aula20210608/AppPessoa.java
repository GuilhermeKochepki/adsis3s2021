package meu.aula20210608;

import meu.aula20210608.repositorio.PessoaRepository;
import meu.aula20210608.pessoa.PessoaFisica;
import meu.aula20210608.pessoa.PessoaJuridica;
import meu.aula20210608.valueObjects.CPF;
import meu.aula20210608.valueObjects.CNPJ;

public class AppPessoa {
	
	public static void main(String[] args) {
		try {
			PessoaRepository repo = new PessoaRepository();
			
			PessoaFisica ana = new PessoaFisica(55, "Ana Maria", new CPF("545.788.865-14"));
			PessoaFisica joaquim = new PessoaFisica(77, "Joaquim Silva", new CPF("123.544.865-55"));
			PessoaJuridica ibm = new PessoaJuridica(21, "IBM INC", new CNPJ("54.554.554/0001-33"));
		
			repo.incluir(ana);
			repo.incluir(joaquim);
			repo.incluir(ibm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Pronto");
	}
	
}
