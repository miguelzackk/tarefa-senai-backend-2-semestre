package contaBancaria;

import java.util.Scanner;

abstract class Conta {
	private int num;
	private String agen;
	private String titular;
	private double saldo;
	private boolean tarifpag;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAgen() {
		return agen;
	}

	public void setAgen(String agen) {
		this.agen = agen;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isTarifpag() {
		return tarifpag;
	}

	public void setTarifpag(boolean tarifpag) {
		this.tarifpag = tarifpag;
	}

	public Conta(int num, String agen, String titular, double saldo, boolean tarifpag) {
		this.num = num;
		this.agen = agen;
		this.titular = titular;
		this.saldo = saldo;
		this.tarifpag = tarifpag;
	}

	public void depositar(Scanner sc) {
		double valor;
		System.out.println("\nDepósito selecionado.");

		while (true) {
			System.out.println("Deseja depositar quanto?");
			valor = sc.nextDouble();

			if (valor <= 0) {
				System.out.println("Depósito inválido. Tente novamente.");
				break;
			}

			saldo = saldo + valor;
			System.out.println("Seu valor foi depositado.");
			System.out.printf("Seu novo saldo é de R$%.2f.%n", saldo);
			break;
		}

	}

	public void sacar(Scanner sc) {
		double valor;
		System.out.println("\nSaque selecionado.");

		while (true) {
			System.out.println("Deseja sacar quanto?");
			valor = sc.nextDouble();

			if (valor <= 0) {
				System.out.println("Saque inválido. Tente novamente.");
				break;
			} else if (valor > saldo) {
				System.out.printf("Não possui saldo suficiente para este saque. \nSeu saldo atual é de R$%.2f.%n",
						saldo);
				break;
			}

			saldo = saldo - valor;
			System.out.println("Seu valor foi sacado.");
			System.out.printf("Seu novo saldo é de R$%.2f.%n", saldo);
			break;
		}
	}

	public void exibirSaldo() {
		System.out.println("\nExibição de saldo selecionado.");
		System.out.printf("Seu saldo é: R$%.2f.%n", saldo);
	}

	public void exibirDados() {
		System.out.println("\nExibição de dados selecionada.");
		System.out.println("Titular da conta: " + titular + ".");
		System.out.println("Número da conta: " + num + ".");
		System.out.println("Agência da conta: " + agen + ".");
	}

	public abstract void tarifaMensal(Scanner sc);
}
