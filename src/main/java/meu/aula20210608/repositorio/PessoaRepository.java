package meu.aula20210608.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import meu.aula20210608.pessoa.Pessoa;
import meu.aula20210608.pessoa.PessoaFisica;
import meu.aula20210608.pessoa.PessoaJuridica;
import meu.aula20210608.valueObjects.CNPJ;
import meu.aula20210608.valueObjects.CPF;

public class PessoaRepository {
	private Connection conexão;
	
	public PessoaRepository() throws Exception {
		try {
			conexão = DriverManager.getConnection("jdbc:h2:~/pessoa","sa","");	//forçar a criação caso não exista
			conexão.close();
		} catch (Exception e) {
			System.out.println("hehe. Já tava criado");
		}
		conexão = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/pessoa","sa","");	//Url / Usuario padrão do h2/ senha. Modo Servidor
		conexão.setAutoCommit(false);
		criarTabelas();
	}
	
	private void criarTabelas() throws Exception {
		String sqlCreatePessoa = "create table if not exists Pessoa ("
				+ "id numeric(18) not null primary key,"
				+ "nome varchar(255) not null, "
				+ "tipo_pessoa varchar(50) not null"
				+ ")";
				
		String sqlCreateFisica = "create table if not exists PessoaFisica ("
				+ "id numeric(18) not null primary key references Pessoa(id), "
				+ "cpf varchar(50) not null unique"
				+ ")";
		
		String sqlCreateJuridica = "create table if not exists PessoaJuridica ("
				+ "id numeric(18) not null primary key references Pessoa(id), "
				+ "cnpj varchar(50) not null unique"
				+ ")";
		conexão.createStatement().execute(sqlCreatePessoa);
		conexão.createStatement().execute(sqlCreateFisica);
		conexão.createStatement().execute(sqlCreateJuridica);
		conexão.commit();
	}
	
	public Pessoa recuperarPeloid(long id) throws Exception {
		Pessoa recuperada = null;
		try {
			PreparedStatement psSelectPessoa = conexão.prepareStatement("select id, nome, tipo_pessoa from pessoa where id = ?");
			PreparedStatement psSelectFisica = conexão.prepareStatement("select id, cpf from pessoaFisica where id = ?");
			PreparedStatement psSelectJuridica = conexão.prepareStatement("select id, cnpj from pessoaJuridica where id = ?");
			
			psSelectPessoa.setLong(1,id);
			ResultSet rsPessoa = psSelectPessoa.executeQuery();
			if (rsPessoa.next()) {
				String nome = rsPessoa.getString("nome");
				String tipoPessoa = rsPessoa.getString("tipo_pessoa");
				if (tipoPessoa.equals("FISICA")) {
					psSelectFisica.setLong(1,id);
					ResultSet rsFisica = psSelectFisica.executeQuery();
					if (rsFisica.next()) {
						recuperada = new PessoaFisica(id, nome, new CPF(rsFisica.getString("cpf")));	
						return recuperada;
					}
				} else if (tipoPessoa.equals("JURIDICA")) {
					psSelectJuridica.setLong(1,id);
					ResultSet rsJuridica = psSelectJuridica.executeQuery();
					if (rsJuridica.next()) {
						recuperada = new PessoaJuridica(id, nome, new CNPJ(rsJuridica.getString("cnpj")));	
						return recuperada;
					}
				}
			} else {
				throw new RuntimeException("Pessoa não encontrada!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recuperada;
	}
	
	public void excluirPeloId(long id) throws Exception {
		try {
			PreparedStatement psDeletePessoa = conexão.prepareStatement("delete from pessoa where id = ?");
			PreparedStatement psDeleteFisica = conexão.prepareStatement("delete from pessoaFisica where id = ?");
			PreparedStatement psDeleteJuridica = conexão.prepareStatement("delete from pessoaJuridica where id = ?");
			
			psDeletePessoa.setLong(1, id);
			psDeleteFisica.setLong(1, id);
			psDeleteJuridica.setLong(1, id);
			
			psDeleteJuridica.execute();
			psDeleteFisica.execute();
			psDeletePessoa.execute();
			
			psDeleteFisica.close();
			psDeleteJuridica.close();
			psDeleteFisica.close();
			conexão.commit();
		} catch (Exception e) {
			conexão.rollback();
			e.printStackTrace();
		}
		
	}
	
	public void incluir (Pessoa pessoa) throws Exception {
		conexão.rollback();
		try {
			PreparedStatement psInsertPessoa = conexão.prepareStatement(
					"insert into pessoa (id, nome, tipo_pessoa) values (?, ?, ?)");
			PreparedStatement psInsertFisica = conexão.prepareStatement(
					"insert into pessoafisica (id, cpf) values (?, ?)");
			PreparedStatement psInsertJuridica = conexão.prepareStatement(
					"insert into pessoajuridica (id, cnpj) values (?, ?)");
			psInsertPessoa.setLong(1, pessoa.getId());
			psInsertPessoa.setString(2, pessoa.getNome());
			if (pessoa instanceof PessoaFisica) {
				psInsertPessoa.setString(3, "FISICA");
			} else if (pessoa instanceof PessoaJuridica) {
				psInsertPessoa.setString(3, "JURIDICA");
			}
			psInsertPessoa.execute();
			
			if (pessoa instanceof PessoaFisica) {
				psInsertFisica.setLong(1, pessoa.getId());
				psInsertFisica.setString(2, ((PessoaFisica) pessoa).getCpf().getValor());
				psInsertFisica.execute();
			} else if (pessoa instanceof PessoaJuridica) {
				psInsertJuridica.setLong(1, pessoa.getId());
				psInsertJuridica.setString(2, ((PessoaJuridica) pessoa).getCnpj().getValor());
				psInsertJuridica.execute();
			}
			conexão.commit();
		} catch (Exception e) {
			conexão.rollback();
			e.printStackTrace();
		}
	}
	
}
