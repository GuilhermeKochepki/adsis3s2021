package meu.aula20210524;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryPersistent implements ProdutoRepository {
	private Connection banco;

	public ProdutoRepositoryPersistent() {		//a conexão será aberta no construtor a fim de ao criar o repositório no app, ele já abrir a conexão
		abrirConexão();
	}
	
	private void abrirConexão() {
		try {
			try {
				banco = DriverManager.getConnection("jdbc:h2:~/bancoFilial","sa","");
				banco.close();
			} catch (Exception e) {
				System.out.println("Já estava criado");
			}
			banco = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/bancoFilial","sa","");
			PreparedStatement psCriarTabela = banco.prepareStatement("create table if not exists produto ("
					+ "codigo number(04) not null,"
					+ "marca varchar(50) not null,"
					+ "modelo varchar(100) not null,"
					+ "quantidade number(04) not null,"
					+ "primary key (codigo)"
					+ ")");
			psCriarTabela.execute();
			psCriarTabela.close();
			System.out.println("Tabela criada com sucesso");
		} catch (Exception f) {
			f.printStackTrace();
		}
		
	}

	public void atualizar(Produto novo) {
		
		try {
			PreparedStatement psInserir = banco.prepareStatement("update produto set marca = ?, modelo = ?, quantidade = ? where codigo = ?");
			//PreparedStatement psInserir = banco.prepareStatement("update produto set marca = ? where sigla = ?");
			//PreparedStatement psInserir = banco.prepareStatement("update produto set modelo = ? where sigla = ?");
			//PreparedStatement psInserir = banco.prepareStatement("update produto set quantidade = ? where sigla = ?");
			psInserir.setString(1, novo.getMarca());
			psInserir.setString(2, novo.getModelo());
			psInserir.setInt(3, novo.getQuantidade());
			psInserir.setInt(4, novo.getCódigo());
			psInserir.execute();
			psInserir.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void salvar(Produto novo) {
		try {
			PreparedStatement psInserir = banco.prepareStatement("insert into produto (codigo, marca, modelo, quantidade) values (?, ?, ?, ?)");
			psInserir.setInt(1, novo.getCódigo());
			psInserir.setString(2, novo.getMarca());
			psInserir.setString(3, novo.getModelo());
			psInserir.setInt(4, novo.getQuantidade());
			psInserir.execute();
			psInserir.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void excluir(Produto novo) {
		try {
			PreparedStatement psDeletar = banco.prepareStatement("delete from produto where codigo = ?");
			psDeletar.setInt(1, novo.getCódigo());
			psDeletar.execute();
			psDeletar.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Produto> obterTodos() {
		List<Produto> todos = new ArrayList<>();
		try {
			PreparedStatement psSelecionar = banco.prepareStatement("select codigo, marca, modelo, quantidade from produto");
			ResultSet rsLista = psSelecionar.executeQuery();
			while (rsLista.next()) {
				Produto listado = new Produto (
						rsLista.getInt("codigo"),
						rsLista.getString("marca"),
						rsLista.getString("modelo"),
						rsLista.getInt("quantidade"));
				todos.add(listado);
			}
			psSelecionar.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return todos;
	}
	
}
