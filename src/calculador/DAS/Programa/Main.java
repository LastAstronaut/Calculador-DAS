package calculador.DAS.Programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		List<Rendas> listaRendas = new ArrayList<Rendas>();
		Scanner input = new Scanner(System.in);
		System.out.println("Calculador DAS");
		System.out.println("**************");
		System.out.println("Seja bem vindo");
		System.out.println("Esse é seu primeiro Acesso?");
		System.out.println("Digite '1' para sim ou '2' para não");
		int resposta = input.nextInt();

		if (resposta == 1) {
			int dozemeses = 12;
			System.out.println("Então iremos te guiar no processo");
			System.out.println("Vamos adicionar suas ultimas rendas ao sistema");
			System.out.println("Lembre-se, adicionaremos os ultimos 12 meses, do mais antigo até o atual.");
			for (int i = 1; i <= dozemeses; i++) {
				System.out.println("Informe: ");
				System.out.print("Mês: ");
				String mes = input.next();
				System.out.print("Valor: ");
				double valor = input.nextDouble();
				Rendas renda = new Rendas(mes, valor);
				listaRendas.add(renda);
				System.out.println("mes anterior: " + mes + " Valor anterior: " + valor);
				System.out.println("********");
				System.out.println("Continue");
				System.out.println("********");

			}

			System.out.println("lista criada com sucesso, vamos checar: " + listaRendas);
			System.out.println("criando arquivo para registro");
			SalvaLista.salvarListaEmArquivo("rendas", listaRendas);

		}

		if (resposta == 2) {
			System.out.println("Acessando arquivo da sessão");
		}

		List<Rendas> registroRendas = LerLista.arquivoParaLista("rendas");
		System.out.println("Pressione '1' para adicionar uma nova renda");
		System.out.println("Pressione '2' para calcular DAS com rendas atuais");
		int resposta2 = input.nextInt();
		if (resposta2 == 1) {
			int valorMeses = 0;
			System.out.println("Quantas rendas serão adicionadas?");
			int quantRendas = input.nextInt();
			System.out.println("Vamos adicionar sua(s) ultima(s) renda(s) ao sistema");
			System.out.println("Lembre-se, sempre adicione da renda  mais antiga para a mais recente");
			valorMeses = quantRendas;
			for (int i = 1; i <= valorMeses; i++) {
				System.out.println("Informe: ");
				System.out.print("Mês: ");
				String mes = input.next();
				System.out.print("Valor: ");
				double valor = input.nextDouble();
				Rendas renda = new Rendas(mes, valor);
				registroRendas.add(renda);
				System.out.println("mes anterior: " + mes + " Valor anterior: " + valor);
				System.out.println("********");
				System.out.println("Continue");
				System.out.println("********");
				
			}
			SalvaLista.salvarListaEmArquivo("rendas", registroRendas);

		} else {
			System.out.println("Vamos somar suas ultimas 12 rendas e calcular o DAS");
		}
		System.out.println("somando valores...");
		double soma = SomaRendas.somar(registroRendas);
		double finalDAS = CategoriasSimplesNacional.defineCategoria(soma);
		String finalDASFormatado = Formatar.formatarEmReais(finalDAS);
		System.out.println("O valor do DAS está em: " + finalDASFormatado);
	}
}
