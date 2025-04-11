import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FilaSimples fila = new FilaSimples(10);

		while (true) {
			System.out.println("\n1-Inserir\n2-Inserir índice\n3-Inserir seq\n4-Remover\n5-Remover índice\n6-Remover seq\n7-Remover todas\n8-Cheia\n9-Vazia\n10-Buscar\n11-Buscar índice\n12-Ordenar C\n13-Ordenar D\n14-Qtd\n15-Dobrar\n16-Editar\n17-Limpar\n18-Exibir\n19-Primeiro\n20-Último\n0-Sair");
			int op;
			try {
				op = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Digite um número.");
				sc.next();
				continue;
			}
			if (op == 0) break;
			switch (op) {
				case 1 -> fila.inserirElemento(sc.next());
				case 2 -> {
					String elem = sc.next();
					int idx;
					try {
						idx = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Índice inválido.");
						sc.next();
						break;
					}
					fila.inserirElementoIndice(elem, idx);
				}
				case 3 -> {
					Object[] seq = {sc.next(), sc.next()};
					fila.inserirSequencia(seq);
				}
				case 4 -> System.out.println(fila.removerElemento());
				case 5 -> {
					int idx;
					try {
						idx = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Índice inválido.");
						sc.next();
						break;
					}
					System.out.println(fila.removerIndice(idx));
				}
				case 6 -> {
					Object[] seq = {sc.next(), sc.next()};
					fila.removerSequencia(seq);
				}
				case 7 -> fila.removerTodasOcorrencias(sc.next());
				case 8 -> System.out.println(fila.estaCheia());
				case 9 -> System.out.println(fila.estaVazia());
				case 10 -> System.out.println(fila.buscarElemento(sc.next()));
				case 11 -> {
					int idx;
					try {
						idx = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Índice inválido.");
						sc.next();
						break;
					}
					System.out.println(fila.buscarElementoIndice(idx));
				}
				case 12 -> fila.ordenarCrescente();
				case 13 -> fila.ordenarDecrescente();
				case 14 -> System.out.println(fila.quantidadeElementos());
				case 15 -> fila.dobrarCapacidade();
				case 16 -> fila.editarElemento(sc.next(), sc.next());
				case 17 -> fila.limpar();
				case 18 -> fila.exibir();
				case 19 -> System.out.println(fila.obterPrimeiroElemento());
				case 20 -> System.out.println(fila.obterUltimoElemento());
			}
		}
		sc.close();
	}
}
