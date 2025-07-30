package teste;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	Pessoa p1 = new Pessoa();
	
	p1.nome = "Pedro";
	p1.idade = 23;
	p1.peso = 65;
	p1.genero = "Não Binário";
	
	System.out.println(p1);
	

	}

}
