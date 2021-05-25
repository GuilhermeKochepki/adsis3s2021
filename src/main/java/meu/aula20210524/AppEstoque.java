package meu.aula20210524;

public class AppEstoque {

	public static void main(String[] args) {
		Produto a0001 = new Produto(0001,"Nike","Boné Azul",120);
		Produto a0002 = new Produto(0002,"Nike","Boné Amarelo",20);
		Produto a0003 = new Produto(0003,"Nike","Boné Preto",140);
		Produto a0004 = new Produto(0004,"Nike","Boné Vermelho Camurça",10);
		
		ProdutoRepository repoFilial = new ProdutoRepositoryPersistent();
		
		repoFilial.salvar(a0001);
		repoFilial.salvar(a0002);
		repoFilial.salvar(a0003);
		repoFilial.salvar(a0004);
		
		imprimirNoConsole(repoFilial);
		
		repoFilial.excluir(a0002);
		
		imprimirNoConsole(repoFilial);
		
	}

	private static void imprimirNoConsole(ProdutoRepository repoFilial) {
		for (Produto i : repoFilial.obterTodos()) {
			System.out.println("\n-------------------");
			System.out.println(i.getCódigo());
			System.out.println(i.getMarca());
			System.out.println(i.getModelo());
			System.out.println("Estoque: " + i.getQuantidade());
		}
		
	}
	
}
