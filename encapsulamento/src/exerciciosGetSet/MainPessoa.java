package exerciciosGetSet;

import java.util.Scanner;

public class MainPessoa {

	public static void main(String[] args) {
		Pessoa person =  new Pessoa();
		Scanner sc = new Scanner(System.in);
		
		boolean validade = false;
		
		System.out.println("Exercício 1 (Não sei o que colocar de boas vindas).");
		
		System.out.println("Digite seu nome:");
		person.setNome(sc.next());
		
		do {
			System.out.println("Digite sua idade:");
			person.setIdade(sc.nextInt());
			
			if (person.getIdade() <= 0) {
				System.out.println("Sua idade é inváliva.");
				validade = false;
			}
			else {
				validade = true;
			}
		} while (validade == false);
		
	
		
		System.out.println("Seu nome é " + person.getNome() + " e sua idade é " + person.getIdade() + ".");
		
	}

}
