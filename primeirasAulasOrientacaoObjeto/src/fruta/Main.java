package fruta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Fruta fruta = new Fruta();

		System.out.println("Digite o nome da sua fruta:");
		fruta.nome = sc.next().toLowerCase();

		System.out.println("Digite a cor da sua fruta:");
		fruta.cor = sc.next().toLowerCase();

		System.out.println(fruta);

		sc.close();

	}

}
