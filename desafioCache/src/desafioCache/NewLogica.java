package desafioCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewLogica {
//fiz o commit no perfil errado, só isso
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Pessoa> banco = new ArrayList<>();

		banco.add(new Pessoa(1, "Bruno", 15));
		banco.add(new Pessoa(2, "Roberto", 24));
		banco.add(new Pessoa(3, "Julia", 45));
		banco.add(new Pessoa(4, "Vitor", 12));
		banco.add(new Pessoa(5, "Sergio", 20));

		List<Pessoa> cache = new ArrayList<>();

		System.out.println("Bem-Vindo ao nosso registro no banco de dados!");

		while (true) {
			System.out.println("\nDeseja o que deseja fazer:");
			System.out.println("1 - Listar dados do banco de dados.");
			System.out.println("2 - Listar cache.");
			System.out.println("3 - Adicionar pessoa ao banco de dados.");
			System.out.println("4 - Adicionar pessoa (via id) no cache.");
			System.out.println("0 - Sair do sistema.");
			System.out.println(
					"\nALERTA - O CACHE ARMAZENA SOMENTE 10 PESSOAS. \nSE ADICIONAR MAIS UMA PESSOA NO CACHE COM O LIMITE ATINGIDO, \nELE IRÁ REMOVER O REGISTRO MAIS ANTIGO E ADICIONARÁ O NOVO.");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				for (Pessoa pessoa : banco) {
					System.out.println(pessoa);
				}
				break;

			case 2:
				if (cache.isEmpty()) {
					System.out.println("O cache está vazio.");
					break;
				}
				for (Pessoa pessoa : cache) {
					System.out.println(pessoa);
				}
				break;

			case 3:
				System.out.println("Digite o id que deseja adicionar.");
				int id = sc.nextInt();

				boolean existid = false;

				for (Pessoa pessoa : banco) {
					if (pessoa.getId() == id) {
						existid = true;
						break;
					}
				}

				if (existid) {
					System.out.println("Já existe um perfil com esse id. \nTente novamente.");
					break;
				}
				System.out.println("Digite o nome do perfil que deseja adicionar.");
				String nome = sc.next();

				System.out.println("Digite a idade do perfil que deseja adicionar.");
				int idade = sc.nextInt();

				banco.add(new Pessoa(id, nome, idade));

				System.out.println("Pessoa adicionada com sucesso!");
				break;

			case 4: {
				System.out.println("Digite o ID do usuário que deseja adicionar no cache.");
				int idBusca = sc.nextInt();

				if (idBusca <= 0) {
					System.out.println("Seu ID é inválido (ID NEGATIVO). Tente novamente.");
					break;
				}

				boolean existeNoBD = false;

				for (Pessoa pessoa : banco) {
					if (pessoa.getId() == idBusca) {
						existeNoBD = true;
						break;
					}
				}

				if (!existeNoBD) {
					System.out.println("O ID inserido não existe no banco de dados!");
					break;
				}

				boolean existeNoCache = false;

				for (Pessoa pessoa : cache) {
					if (pessoa.getId() == idBusca) {
						existeNoCache = true;
						break;
					}
				}
				if (existeNoCache) {
					System.out.println("O ID inserido já está adicionado no cache.");
					break;
				}

				Pessoa pessoaadd = null;
				for (Pessoa pessoa : banco) {
					if (pessoa.getId() == idBusca) {
						pessoaadd = pessoa;
						break;
					}
				}

				if (cache.size() == 10) {
					cache.remove(0);
				}

				cache.add(pessoaadd);
				System.out.println("Pessoa adicionada no cache!");

				break;
			}

			case 0:
				System.out.println("Saindo.");
				return;
			default:
				System.out.println("Valor inválido. Tente novamente.");
				break;
			}

			sc.close();
		}

	}
}
