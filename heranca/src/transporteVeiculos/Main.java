package transporteVeiculos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int parad;

		System.out.println("Bem-vindo ao nosso sistema de transporte!");
		System.out.println("Saiba em quanto tempo você vai chegar ao destino!");

		while (true) {

			System.out.println("\nDigite 1 para calcular ou 0 para sair:");
			int opcao = sc.nextInt();

			if (opcao == 0) {
				System.out.println("Programa encerrado. Até mais!");
				break;
			}
			if (opcao != 1) {
				System.out.println("Opção inválida. Tente novamente.");
				continue;
			}

			float distance;
			do {
				System.out.println("Digite a distância do percurso (em km):");
				distance = sc.nextFloat();
				if (distance <= 0) {
					System.out.println("A distância deve ser positiva.");
				}
			} while (distance <= 0);

			int menu;
			while (true) {
				System.out.println("Digite qual veículo deseja ver o tempo: \n"
						+ "1 - Ônibus \n2 - Bicicleta \n3 - Carro \n4 - Todos");
				menu = sc.nextInt();
				if (menu >= 1 && menu <= 4)
					break;
				System.out.println("Número inválido. Tente novamente.");
			}

			switch (menu) {
			case 1:
				System.out.println("Digite quantas paradas tem no trajeto do ônibus:");
				parad = sc.nextInt();
				Onibus bus = new Onibus(distance, 60, parad);
				bus.calcularTempo();
				break;
			case 2:
				Bicicleta bike = new Bicicleta(distance, 20);
				bike.calcularTempo();
				break;
			case 3:
				Carro car = new Carro(distance, 80);
				car.calcularTempo();
				break;
			case 4:
				System.out.println("Digite quantas paradas tem no trajeto do ônibus:");
				parad = sc.nextInt();
				Onibus bus1 = new Onibus(distance, 60, parad);
				bus1.calcularTempo();
				Bicicleta bike1 = new Bicicleta(distance, 20);
				bike1.calcularTempo();
				Carro car1 = new Carro(distance, 80);
				car1.calcularTempo();
				break;
			}
		}

		sc.close();
	}
}
