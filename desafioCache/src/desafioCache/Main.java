package desafioCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		List<Pessoa> banco = new ArrayList<>();
		banco.add(new Pessoa(1, "Alice", 25));
		banco.add(new Pessoa(2, "Bruno", 30));
		banco.add(new Pessoa(3, "Carla", 22));
		banco.add(new Pessoa(4, "Daniel", 28));
		banco.add(new Pessoa(5, "Ester", 35));

		List<Pessoa> cache = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		System.out.print("Bem-vindo ao nosso sistema de registro de pessoas!");
		System.out.println("\nPara utilizar, use da seguinte maneira:");
		while (true) {

			System.out.println(
					"\nDigite o ID da pessoa que está armazenada no banco para adicionar no cache. \nDigite -1 para adicionar uma pessoa ao banco. \nDigite -2 para visualizar o cache. \nALERTA: O LIMITE DO CACHE É DE 10 PESSOAS. \nSE TENTAR ARMAZENAR UMA ESTANDO NO LIMITE, O RESGISTRO MAIS ANTIGO SERÁ APAGADO.");
			int id = sc.nextInt();

			if (id == 0) {
				System.out.println("Encerrando programa...");
				break;
			}

			if (id == -1) {

				System.out.print("Digite o ID da nova pessoa: ");
				int novoId = sc.nextInt();
				sc.nextLine();

				System.out.print("Digite o nome da nova pessoa: ");
				String nome = sc.nextLine();

				System.out.print("Digite a idade da nova pessoa: ");
				int idade = sc.nextInt();

				banco.add(new Pessoa(novoId, nome, idade));

				System.out.println("Pessoa adicionada ao banco.");
				continue;
			}

			if (id == -2) {

				if (cache.isEmpty()) {
					System.out.println("Cache está vazio.");
				} else {
					System.out.println("Conteúdo do cache:");
					for (Pessoa p : cache) {
						System.out.println(p);
					}
				}
				continue;
			}

			Pessoa encontrada = null;

			for (Pessoa p : cache) {
				if (p.getId() == id) {
					encontrada = p;
					break;
				}
			}

			if (encontrada != null) {
				System.out.println("Pessoa encontrada no cache: " + encontrada);
			} else {

				for (Pessoa p : banco) {
					if (p.getId() == id) {
						encontrada = p;
						break;
					}
				}

				if (encontrada != null) {
					if (cache.size() == 10) {
						cache.remove(0);
					}
					cache.add(encontrada);
					System.out.println("Pessoa buscada no banco e adicionada ao cache: " + encontrada);
				} else {
					System.out.println("Pessoa com ID " + id + " não encontrada.");
				}
			}
		}

		sc.close();
	}
}
