package contaBancaria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ContaBancaria banco = new ContaBancaria();

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println(
					"Bem-vindo(a) ao seu banco! Defina que operação você fará: \n1- Consultar saldo. \n2- Fazer depósito. \n3- Fazer saque. \n4- Sair do banco.");
			banco.setOptionmenu(sc.nextInt());

			switch (banco.getOptionmenu()) {
			case 1:
				banco.saldo();
				break;

			case 2:
				banco.deposito(sc);
				break;

			case 3:
				banco.saque(sc);
				break;

			case 4:
				System.out.println("Obrigado por utilizar o nosso banco!");
				banco.setOptionmenu(0);
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
			
			System.out.println("\n");
		} while (banco.getOptionmenu() != 0);

		sc.close();
	}
}
