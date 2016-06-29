import java.util.Locale;
import java.util.Scanner;

public class prog {
	/**
	 * Programa de controle de estoque e venda.
	 * Trabalho 03 Professor Nelio Alves
	 * @author Murilo Miller
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		int n, op, cod[];
		double quant[], prec[];
		String desc[];

		System.out.println("Digite a quantidade de produtos: ");
		n = sc.nextInt();

		cod = new int[n];
		desc = new String[n];
		prec = new double[n];
		quant = new double[n];

		// gera a tabela de preços
		gerarTabela(cod, desc, prec, quant);

		// Mostra o menu
		menu();
		op = sc.nextInt();
		while (op != 7) {
			if (op == 1) {
				// Imprime a tabela de preços
				imprimirTabela(cod, desc, prec, quant);
			} else if (op == 2) {
				// Pesquisa produto
				pesquisaProduto(cod, desc, prec, quant);
			} else if (op == 3) {
				// Mostra dados produto mais caro
				maisCaro(cod, desc, prec, quant);
			} else if (op == 4) {
				// Mostrar produto cuja quantidade está abaixo de 10
				quantMenor10(cod, desc, prec, quant);
			} else if (op == 5) {
				// Ativo total do estoque
				ativo(cod, desc, prec, quant);
			} else if (op == 6) {
				// Efetuar venda
				venda(cod, desc, prec, quant);
			}
			System.out.println();
			menu();
			op = sc.nextInt();
		}
		sc.close();
	}

	/**
	 * Gera a tabela de preço.
	 * @param cod vetor que armazena os codigos dos produtos
	 * @param desc vetor que armazena as descrições dos produtos
	 * @param prec vetor que armazena  o valor unitario dos produtos
	 * @param quant vetor que armazena a quantidade total dos produtos em estoque
	 */
	public static void gerarTabela(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		System.out.println("Digite os dados da tabela de preços: ");
		for (int i = 0; i < cod.length; i++) {
			System.out.print("Digite o código do produto: ");
			cod[i] = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite a descrição do produto: ");
			desc[i] = sc.nextLine();
			System.out.print("Digite o preço do produto: ");
			prec[i] = sc.nextDouble();
			System.out.print("Digite a quantidade do produto em estoque: ");
			quant[i] = sc.nextDouble();
		}
	}
	/**
	 * Mostra a tabela de preço.
	 * @param cod vetor que armazena os codigos dos produtos
	 * @param desc vetor que armazena as descrições dos produtos
	 * @param prec vetor que armazena  o valor unitario dos produtos
	 * @param quant vetor que armazena a quantidade total dos produtos em estoque
	 */
	public static void imprimirTabela(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		System.out.println("Esta é a tabela atual ");
		System.out.println("CODIGO\t|Produto\t|Preço\t|Quantidade\t|");

		for (int i = 0; i < cod.length; i++) {
			System.out.println(cod[i] + "\t|" + desc[i] + "\t|" + prec[i] + "\t|" + quant[i] + "\t\t|");
		}
	}
	/**
	 * Mostra o menu na tela.
	 */
	public static void menu() {
		System.out.println("1 - Imprimir Tabela");
		System.out.println("2 - Pesquisar Produto");
		System.out.println("3 - Mostrar dados do produto mais caro");
		System.out.println("4 - Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10");
		System.out.println("5 - Ativo total do estoque");
		System.out.println("6 - Efetuar uma venda");
		System.out.println("7 - Sair");

	}
	/**
	 * Pesquisa o produto.
	 * @param cod
	 * @param desc
	 * @param prec
	 * @param quant
	 */
	public static void pesquisaProduto(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		int prod;
		System.out.print("Digite o codigo do produto desejado: ");
		prod = sc.nextInt();
		System.out.println("CODIGO\t|Produto\t|Preço\t|Quantidade\t|");
		for (int i = 0; i < cod.length; i++) {
			if (prod == cod[i]) {
				System.out.println(cod[i] + "\t|" + desc[i] + "\t|" + prec[i] + "\t|" + quant[i] + "\t\t|");
				System.out.println();
			}
			else if(prod != cod[i]){
				System.out.println("Produto inexistente, voltando ao menu.");
				System.out.println();
			}
		}
	}
	/**
	 * Mostra o produto mais caro.
	 * @param cod
	 * @param desc
	 * @param prec
	 * @param quant
	 */
	public static void maisCaro(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		System.out.println("Este é o produto mais caro");

		int pos;
		double precoinicial;
		precoinicial = 0;
		pos = 0;
		for (int i = 0; i < prec.length; i++) {
			if (prec[i] > precoinicial)
				precoinicial = prec[i];
			pos = i;
		}
		System.out.println("CODIGO\t|Produto\t|Preço\t|Quantidade\t|");
		System.out.println(cod[pos] + "\t|" + desc[pos] + "\t|" + prec[pos] + "\t|" + quant[pos] + "\t|");
	}
	/**
	 * Mostra produto com quantidade menor que 10.
	 * @param cod
	 * @param desc
	 * @param prec
	 * @param quant
	 */
	public static void quantMenor10(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		System.out.println("CODIGO\t|Descrição\t|");
		for (int i = 0; i < quant.length; i++) {
			if (quant[i] < 10) {
				System.out.println(cod[i] + "\t|" + desc[i] + "\t|");
			}
		}
	}
	/**
	 * Mostra o ativo total em estoque.
	 * @param cod
	 * @param desc
	 * @param prec
	 * @param quant
	 */
	public static void ativo(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		double ativop, ativototal;
		ativototal = 0;

		for (int i = 0; i < quant.length; i++) {
			ativop = quant[i] * prec[i];
			ativototal = ativototal + ativop;
		}
		System.out.println("Total do ativo: " + ativototal + " R$");
	}
	/**
	 * Efetua venda.
	 * @param cod
	 * @param desc
	 * @param prec
	 * @param quant
	 */
	public static void venda(int cod[], String desc[], double prec[], double quant[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		int i, j, codVen, qtdVen, pos;
		System.out.println("Digite o código do produto: ");
		codVen = sc.nextInt();
		for (i = 0; i < cod.length; i++) {
			if (codVen == cod[i]) {
				pos = i;
				System.out.println("Informe a quantidade a ser vendida: ");
				qtdVen = sc.nextInt();
				for (j = 0; j < cod.length; j++) {
					if (quant[pos] < qtdVen) {
						System.out.println("Quantidade Insuficiente, voltando ao menu.");
						System.out.println();
					} else {
						quant[pos] = quant[pos] - qtdVen;
						System.out.println("Termino da venda.");
					}
				}
			} 
			else {
				System.out.println("Código Inexistente, voltando ao menu");
				System.out.println();
			}
		}
	}
}