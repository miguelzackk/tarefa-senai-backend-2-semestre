package contaBancaria;

import java.util.Scanner;

public class ContaBancaria {

	private double saldo;
	private double deposito;
	private double saque;
	public int optionmenu;
	public boolean valuemenu;

	public void saldo() {
		System.out.println("Seu saldo é: " + saldo);
	}

	public void deposito() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Insira o valor que deseja depositar:");
			deposito = sc.nextDouble();
			if (deposito <= 0) {
				System.out.println("O valor inserido é inválido.");
			} else {
				valuemenu = false;
			}
		} while (valuemenu);
		saldo = saldo + deposito;
		System.out.println("Seu novo saldo é: " + saldo);
		sc.close();
	}

	public void saque() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Insira o valor que deseja sacar:");
			saque = sc.nextDouble();
			if (saque > saldo) {
				System.out.println("Valor inválido. Seu saldo é insuficiente");
			} else if (saque <= 0) {
				System.out.println("O valor inserido é inválido.");
			} else {
				valuemenu = false;
			}
		} while (valuemenu);
		saldo = saldo - saque;
		System.out.println("Seu novo saldo é: " + saldo);
		sc.close();
	}

}
