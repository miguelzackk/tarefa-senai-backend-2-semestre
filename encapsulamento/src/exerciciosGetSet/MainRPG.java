package exerciciosGetSet;

import java.util.Scanner;

public class MainRPG {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = 0;

		do {
			PersonagemRPG personagem = new PersonagemRPG();

			System.out.println("Bem-vindo ao sistema de RPG. Adicione seu personagem!");

			System.out.println("Digite o nome do personagem:");
			String nome = sc.nextLine();
			personagem.setNome(nome);

			System.out.println("Digite a classe do personagem (exemplo: Guerreiro, Mago, Arqueiro):");
			String classe = sc.nextLine();
			personagem.setClasse(classe);

			int nivel;
			do {
				System.out.println("Digite o nível do personagem (deve ser >= 1):");
				while (!sc.hasNextInt()) {
					System.out.println("Por favor, digite um número válido para o nível:");
					sc.next();
				}
				nivel = sc.nextInt();
				sc.nextLine();
				personagem.setNivel(nivel);
			} while (personagem.getNivel() < 1);

			int vida;
			do {
				System.out.println("Digite a vida do personagem (entre 0 e 100):");
				while (!sc.hasNextInt()) {
					System.out.println("Por favor, digite um número válido para a vida:");
					sc.next();
				}
				vida = sc.nextInt();
				sc.nextLine(); // Limpa o buffer
				personagem.setVida(vida);
			} while (personagem.getVida() < 0 || personagem.getVida() > 100);

			System.out.println("\nPersonagem cadastrado com sucesso!");
			System.out.println("Nome: " + personagem.getNome());
			System.out.println("Classe: " + personagem.getClasse());
			System.out.println("Nível: " + personagem.getNivel());
			System.out.println("Vida: " + personagem.getVida());

			System.out.println("\nMenu de opções: \n[0] - Sair \n[1] - Adicionar mais personagens.");
			while (true) {
				if (sc.hasNextInt()) {
					i = sc.nextInt();
					sc.nextLine();
					if (i == 0 || i == 1) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Opção inválida. Tente novamente: [0] - Sair | [1] - Adicionar mais personagens.");
			}

		} while (i == 1);

		sc.close();
		System.out.println("Encerrando o sistema.");
	}
}
