package meu.aula20210524;

import java.util.List;

public interface ProdutoRepository {

	void atualizar(Produto novo);

	void salvar(Produto novo);

	void excluir(Produto novo);
	
	List<Produto> obterTodos();
	
}
