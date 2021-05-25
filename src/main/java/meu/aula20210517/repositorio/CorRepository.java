package meu.aula20210517.repositorio;

//cria contrato de código
//

import java.util.List;

public interface CorRepository {
	
	void atualizar(Cor nova);

	void salvar(Cor nova);

	void excluir(Cor cor);
	
	List<Cor> obterTodas();
}
