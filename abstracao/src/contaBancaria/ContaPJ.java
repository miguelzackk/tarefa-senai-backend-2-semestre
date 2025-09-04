package contaBancaria;

import java.util.Scanner;

public class ContaPJ extends Conta {

	public ContaPJ(int num, String agen, String titular, double saldo, boolean tarifpag) {
		super(num, agen, titular, saldo, tarifpag);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tarifaMensal(Scanner sc) {
		System.out.println("\nEsta conta possui tarifa.");
		System.out.println("A tarifa fixa mensal desta conta é R$20,00.");

		while (true) {
			System.out.println(
					"\nSelecione o que deseja fazer. \n1 - Verificar status de pagamento da tarifa. \n2 - Pagar tarifa. \n0 - Sair");
			int menutarif = sc.nextInt();

			switch (menutarif) {
			case 1:
				if (isTarifpag() == false) {
					System.out.println("\nA tarifa não foi paga.");
				} else {
					System.out.println("\nA tarifa foi paga.");
				}
				break;

			case 2:
				if (getSaldo() < 12) {
					System.out.println("Saldo insuficiente para pagamento. Faça um depósito e tente novamente.");

				} else if (isTarifpag() == true) {
					System.out.println("Sua tarifa já foi paga anteriormente.");
				} else {
					setSaldo(getSaldo() - 20);
					setTarifpag(true);
					System.out.printf("\nTarifa paga com sucesso. Seu novo saldo é R$%.2f.%n", getSaldo());
				}
				break;

			case 0:
				System.out.println("Retornando.");
				return;
			default:
				System.out.println("Valor inválido. Escolha um valor correspondente ao menu.");
				break;
			}

		}

	}

	public void contaPJ(Scanner sc) {
		int menu;
		System.out.println("\nSua conta é Conta Pessoa Jurídica (PJ).");

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
				double valor;
				System.out.println("\nSaque selecionado.");

				while (true) {
					System.out.println("A taxa de saque é de R$1,50.");
					System.out.println("Deseja sacar quanto?");
					valor = sc.nextDouble();

					if (valor <= 0) {
						System.out.println("Saque inválido. Tente novamente.");
						break;
					} else if (valor + 1.5 > getSaldo()) {
						System.out.printf(
								"Não possui saldo suficiente para este saque. \nSeu saldo atual é de R$%.2f.%n",
								getSaldo());
						break;
					}

					setSaldo((getSaldo() - valor) - 1.5);
					System.out.println("Seu valor foi sacado.");
					System.out.printf("Seu novo saldo é de R$%.2f.%n", getSaldo());

					break;
				}
				break;
			case 4:
				exibirDados();
				System.out.println("Sua conta é Conta Pessoa Jurídica.");
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