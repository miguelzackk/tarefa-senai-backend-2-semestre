package contaBancaria;

import java.util.Scanner;

public class ContaBancaria {

	private double saldo;
	private double deposito;
	private double saque;
	public int optionmenu;
	public boolean valuemenu;

	public void saldo() {
		System.out.printf("Seu saldo é: R$%.2f.%n", saldo);
	}

	public void deposito(Scanner sc) {
		do {
			System.out.println("Digite o valor que deseja depositar:");
			deposito = sc.nextDouble();

			if (deposito <= 0) {
				System.out.println("Valor inválido.");
				valuemenu = true;
			} else {
				saldo = saldo + deposito;
				System.out.printf("Valor adicionado! \nSeu novo saldo é: R$%.2f.%n", saldo);
				valuemenu = false;
			}

		} while (valuemenu == true);

	}

	public void saque(Scanner sc) {
		if (saldo == 0) {
			System.out.println("Você está sem saldo!");
		} else {
			do {
				System.out.println("Digite o valor que deseja sacar:");
				saque = sc.nextDouble();

				if (saque <= 0) {
					System.out.println("Valor inválido.");
					valuemenu = true;
				} else if (saldo < saque) {
					System.out.printf("Saldo insuficiente. \nSeu saldo é de: R$%.2f. Faça um saque válido.%n", saldo);
					valuemenu = true;
				} else {
					saldo = saldo - saque;
					System.out.printf("Valor sacado! \nSeu novo saldo é: R$%.2f.%n", saldo);
					valuemenu = false;
				}

			} while (valuemenu == true);

		}

	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}

	public double getSaque() {
		return saque;
	}

	public void setSaque(double saque) {
		this.saque = saque;
	}

	public int getOptionmenu() {
		return optionmenu;
	}

	public void setOptionmenu(int optionmenu) {
		this.optionmenu = optionmenu;
	}

}
