package meu.aula20210608;

import meu.aula20210608.repositorio.PessoaRepository;

import javax.swing.JOptionPane;

import meu.aula20210608.pessoa.Pessoa;
import meu.aula20210608.pessoa.PessoaFisica;
import meu.aula20210608.pessoa.PessoaJuridica;
import meu.aula20210608.valueObjects.CPF;
import meu.aula20210608.valueObjects.CNPJ;

public class AppPessoa {
	
	public static void main(String[] args) {
		try {
			PessoaRepository repo = new PessoaRepository();
			
			repo.excluirPeloId(55);
			repo.excluirPeloId(77);
			repo.excluirPeloId(21);
			
			PessoaFisica ana = new PessoaFisica(55, "Ana Maria", new CPF("545.788.865-14"));
			PessoaFisica joaquim = new PessoaFisica(77, "Joaquim Silva", new CPF("123.544.865-55"));
			PessoaJuridica ibm = new PessoaJuridica(21, "IBM INC", new CNPJ("54.554.554/0001-33"));
		
			repo.incluir(ana);
			repo.incluir(joaquim);
			repo.incluir(ibm);
			
			JOptionPane.showConfirmDialog(null, "Opa, incluídos!");
			
			Pessoa recuperadaPeloId = repo.recuperarPeloid(77);
			System.out.println("Pessoa recuperada pelo id: " 
					+ recuperadaPeloId.getNome() + "  "
					+ recuperadaPeloId.getId() + "  "
					+ recuperadaPeloId.getClass());
			JOptionPane.showConfirmDialog(null, "Vamos excluir o 21!");
			
			repo.excluirPeloId(21);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Pronto");
	}
	
}
