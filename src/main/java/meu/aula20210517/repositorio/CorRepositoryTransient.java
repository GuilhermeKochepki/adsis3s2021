package meu.aula20210517.repositorio;

//transient é salvo em memória
//exemplo. Caso desligue, quando ligar não estará salvo

import java.util.ArrayList;
import java.util.List;

public class CorRepositoryTransient implements CorRepository{
	private List<Cor> cores = new ArrayList<>();
	
	public void salvar(Cor nova) {
		cores.add(nova);
	}

	public void excluir(Cor cor) {
		cores.remove(cor);
	}
	
	public List<Cor> obterTodas() {
		return cores;
	}
}
