package contaBancaria;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int num, String agen, String titular, double saldo, boolean tarifpag) {
		super(num, agen, titular, saldo, tarifpag);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tarifaMensal(Scanner sc) {
		System.out.println("\nEsta conta não possui tarifa.");
	}

	public void contaP(Scanner sc) {
		int menu;
		System.out.println("\nSua conta é Conta Poupança (CP).");

		while (true) {

			System.out.println(
					"\nSelecione o que deseja fazer: \n1 - Exibir saldo. \n2 - Realizar depósito. \n3 - Realizar saque. \n4 - Exibir dados da conta. \n5 - Verificar tarifa mensal. \n0 - Sair.");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				exibirSaldo();
				break;

			case 2:
				depositar(sc);
				break;

			case 3:
				sacar(sc);
				break;

			case 4:
				exibirDados();
				System.out.println("Sua conta é Conta Poupança.");
				break;

			case 5:
				tarifaMensal(sc);
				break;

			case 0:
				return;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

}