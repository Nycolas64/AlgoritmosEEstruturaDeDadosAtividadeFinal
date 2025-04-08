import java.util.Arrays;

public class FilaSimples implements IEstruturaSimples {
	private int tamanho;
	private Object[] fila;
	private int pos;

	public FilaSimples(int tamanho) {
		this.tamanho = tamanho;
		this.fila = new Object[tamanho];
		this.pos = 0;
	}

	public void inserirElemento(Object elemento) {
		if (!estaCheia()) fila[pos++] = elemento;
	}

	public void inserirElementoIndice(Object elemento, int indice) {
		if (indice >= 0 && indice <= pos && !estaCheia()) {
			for (int i = pos; i > indice; i--) fila[i] = fila[i - 1];
			fila[indice] = elemento;
			pos++;
		}
	}

	public void inserirSequencia(Object elementos) {
		Object[] arr = (Object[]) elementos;
		for (Object el : arr) inserirElemento(el);
	}

	public boolean removerElemento() {
		if (estaVazia()) return false;
		for (int i = 0; i < pos - 1; i++) fila[i] = fila[i + 1];
		fila[--pos] = null;
		return true;
	}

	public Object removerIndice(int indice) {
		if (indice >= pos) return null;
		Object removido = fila[indice];
		for (int i = indice; i < pos - 1; i++) fila[i] = fila[i + 1];
		fila[--pos] = null;
		return removido;
	}

	public void removerSequencia(Object elementos) {
		Object[] arr = (Object[]) elementos;
		for (Object el : arr) removerTodasOcorrencias(el);
	}

	public void removerTodasOcorrencias(Object elemento) {
		int i = 0;
		while (i < pos) {
			if (fila[i].equals(elemento)) removerIndice(i);
			else i++;
		}
	}

	public boolean estaCheia() {
		return pos == tamanho;
	}

	public boolean estaVazia() {
		return pos == 0;
	}

	public boolean buscarElemento(Object elemento) {
		for (int i = 0; i < pos; i++)
			if (fila[i].equals(elemento)) return true;
		return false;
	}

	public Object buscarElementoIndice(int indice) {
		if (indice >= 0 && indice < pos) return fila[indice];
		return null;
	}

	public void ordenarCrescente() {
		Arrays.sort(fila, 0, pos);
	}

	@SuppressWarnings("unchecked")
    public void ordenarDecrescente() {
    Arrays.sort(fila, 0, pos, (a, b) -> ((Comparable<Object>) b).compareTo(a));
    }

	public int quantidadeElementos() {
		return pos;
	}

	public void dobrarCapacidade() {
		tamanho *= 2;
		fila = Arrays.copyOf(fila, tamanho);
	}

	public void editarElemento(Object antigo, Object novo) {
		for (int i = 0; i < pos; i++)
			if (fila[i].equals(antigo)) fila[i] = novo;
	}

	public void limpar() {
		for (int i = 0; i < pos; i++) fila[i] = null;
		pos = 0;
	}

	public void exibir() {
		for (int i = 0; i < pos; i++) System.out.println(fila[i]);
	}

	public Object obterPrimeiroElemento() {
		return estaVazia() ? null : fila[0];
	}

	public Object obterUltimoElemento() {
		return estaVazia() ? null : fila[pos - 1];
	}
}
