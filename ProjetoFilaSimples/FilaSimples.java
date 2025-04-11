public class FilaSimples implements IEstruturaSimples {
	private Object[] dados;
	private int fim = 0;

	public FilaSimples(int capacidade) {
		dados = new Object[capacidade];
	}

	public void inserirElemento(Object elemento) {
		if (fim < dados.length)
			dados[fim++] = elemento;
	}

	public void inserirElementoIndice(Object elemento, int indice) {
		if (fim < dados.length && indice >= 0 && indice <= fim) {
			for (int i = fim; i > indice; i--)
				dados[i] = dados[i - 1];
			dados[indice] = elemento;
			fim++;
		}
	}

	public void inserirSequencia(Object elementos) {
		if (elementos instanceof Object[]) {
			Object[] seq = (Object[]) elementos;
			for (Object e : seq)
				inserirElemento(e);
		}
	}

	public boolean removerElemento() {
		if (fim == 0) return false;
		for (int i = 0; i < fim - 1; i++)
			dados[i] = dados[i + 1];
		dados[--fim] = null;
		return true;
	}

	public Object removerIndice(int indice) {
		if (indice < 0 || indice >= fim) return null;
		Object removido = dados[indice];
		for (int i = indice; i < fim - 1; i++)
			dados[i] = dados[i + 1];
		dados[--fim] = null;
		return removido;
	}

	public void removerSequencia(Object elementos) {
		if (elementos instanceof Object[] seq) {
			for (Object e : seq)
				removerTodasOcorrencias(e);
		}
	}

	public void removerTodasOcorrencias(Object elemento) {
		int i = 0;
		while (i < fim) {
			if (dados[i].equals(elemento))
				removerIndice(i);
			else
				i++;
		}
	}

	public boolean estaCheia() {
		return fim == dados.length;
	}

	public boolean estaVazia() {
		return fim == 0;
	}

	public boolean buscarElemento(Object elemento) {
		for (int i = 0; i < fim; i++)
			if (dados[i].equals(elemento))
				return true;
		return false;
	}

	public Object buscarElementoIndice(int indice) {
		if (indice < 0 || indice >= fim) return null;
		return dados[indice];
	}

	public void ordenarCrescente() {
		for (int i = 0; i < fim - 1; i++) {
			for (int j = 0; j < fim - i - 1; j++) {
				if (dados[j].toString().compareTo(dados[j + 1].toString()) > 0) {
					Object tmp = dados[j];
					dados[j] = dados[j + 1];
					dados[j + 1] = tmp;
				}
			}
		}
	}

	public void ordenarDecrescente() {
		for (int i = 0; i < fim - 1; i++) {
			for (int j = 0; j < fim - i - 1; j++) {
				if (dados[j].toString().compareTo(dados[j + 1].toString()) < 0) {
					Object tmp = dados[j];
					dados[j] = dados[j + 1];
					dados[j + 1] = tmp;
				}
			}
		}
	}

	public int quantidadeElementos() {
		return fim;
	}

	public void dobrarCapacidade() {
		Object[] novo = new Object[dados.length * 2];
		for (int i = 0; i < fim; i++)
			novo[i] = dados[i];
		dados = novo;
	}

	public void editarElemento(Object antigo, Object novoElemento) {
		for (int i = 0; i < fim; i++)
			if (dados[i].equals(antigo))
				dados[i] = novoElemento;
	}

	public void limpar() {
		for (int i = 0; i < fim; i++)
			dados[i] = null;
		fim = 0;
	}

	public void exibir() {
		for (int i = 0; i < fim; i++)
			System.out.print(dados[i] + " ");
		System.out.println();
	}

	public Object obterPrimeiroElemento() {
		return fim > 0 ? dados[0] : null;
	}

	public Object obterUltimoElemento() {
		return fim > 0 ? dados[fim - 1] : null;
	}
}
