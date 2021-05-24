package meu.aula20210517.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Para executar o banco de dados H2, copie o pathname do arquivo jar do h2 das
 * dependências do maven de seu projeto. Retire a parte do "-source" e vá para o CMD.
 * Lá digite java -jar com o path do h2.
 * 
 * Exemplo no caso do lab da UniCesumar:
 * java -jar C:/Users/ADM/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar
 *  
 * @author ADM
 *
 */

//persistencia é sempre salvo

public class CorRepositoryPersistent implements CorRepository{
	private Connection conexão;	//Connection é um método do java.sql. Conexão é o nome que criei
	
	public CorRepositoryPersistent() {
		abrirConexão();
	}
	
	private void abrirConexão() {
		try {
			try {
				conexão = DriverManager.getConnection("jdbc:h2:~/adsis3s2021","sa","");	//forçar a criação caso não exista
				conexão.close();
			} catch (Exception e) {
				System.out.println("hehe. Já tava criado");
			}
			conexão = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/adsis3s2021","sa","");	//Url / Usuario padrão do h2/ senha. Modo Servidor
			PreparedStatement psCreateTable =  conexão.prepareStatement("create table if not exists cor ("
					+ "nome varchar(255) not null, "
					+ "sigla varchar(30) not null"
					+ ")");
			psCreateTable.execute();
			psCreateTable.close();
			System.out.println("Foi.");
		} catch (Exception e) {
			e.printStackTrace();		//envia a saída do rastreamento de	pilha para o fluxo de erros padrão.
		}
	}

	public void salvar(Cor nova) {
		try {
			PreparedStatement psInsert =  conexão.prepareStatement(
					"insert into cor (nome, sigla) values (?,?)");
			psInsert.setString(1, nova.getNome());  //1 por ser o primeiro parâmetro do insert, e 2o para capturar o nome passado como parametro do método salvar
			psInsert.setString(2, nova.getSigla());
			psInsert.execute();
			psInsert.close();
		} catch (Exception e) {
			e.printStackTrace();		//envia a saída do rastreamento de	pilha para o fluxo de erros padrão.
		}
	}

	public void excluir(Cor cor) {
		
	}
	
	public List<Cor> obterTodas() {
		List<Cor> todas = new ArrayList<>();
		try {
			PreparedStatement psSelect =  conexão.prepareStatement(
					"select nome, sigla from cor");
			ResultSet rsTodas = psSelect.executeQuery(); //retorna o resultado, os dados. o rsTodas contem todos os métodos para pegar dados do banco
			while(rsTodas.next()) {	//enquanto possuir um próximo??? Perguntar pro professor
				Cor recuperada = new Cor(
						rsTodas.getString("nome"), 
						rsTodas.getString("sigla"));
				todas.add(recuperada);
			}
			psSelect.close();
		} catch (Exception e) {
			e.printStackTrace();		//envia a saída do rastreamento de	pilha para o fluxo de erros padrão.
		}
		return todas;
	}
	
}
