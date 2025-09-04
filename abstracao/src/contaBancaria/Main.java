package contaBancaria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem-Vindo ao nosso banco.");
		System.out.println("Preencha seus dados para acessar sua conta.");

		System.out.print("Nome do titular: ");
		String titular = sc.nextLine();

		System.out.print("Número da conta: ");
		int numero = sc.nextInt();

		System.out.print("Agência: ");
		String agencia = sc.next();

		int opcao;
		while (true) {
			System.out.println("\nSelecione o tipo de conta que deseja criar:");
			System.out.println("1 - Conta Corrente");
			System.out.println("2 - Conta Poupança");
			System.out.println("3 - Conta Pessoa Jurídica (PJ)");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				ContaCorrente cc = new ContaCorrente(numero, agencia, titular, 0.0, false);
				System.out.println("\nConta Corrente criada com sucesso!");
				System.out.println("Titular: " + cc.getTitular());
				System.out.println("Número: " + cc.getNum());
				System.out.println("Agência: " + cc.getAgen());
				cc.contaCC(sc);
				break;

			case 2:
				ContaPoupanca cp = new ContaPoupanca(numero, agencia, titular, 0.0, false);
				System.out.println("\nConta Poupança criada com sucesso!");
				System.out.println("Titular: " + cp.getTitular());
				System.out.println("Número: " + cp.getNum());
				System.out.println("Agência: " + cp.getAgen());
				cp.contaP(sc);
				break;

			case 3:
				ContaPJ pj = new ContaPJ(numero, agencia, titular, 0.0, false);
				System.out.println("\nConta Pessoa Jurídica criada com sucesso!");
				System.out.println("Titular: " + pj.getTitular());
				System.out.println("Número: " + pj.getNum());
				System.out.println("Agência: " + pj.getAgen());
				pj.contaPJ(sc);
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
			System.out.println("\nObrigado por usar o nosso banco! Até a próxima!");
			break;
		}
	}
}
