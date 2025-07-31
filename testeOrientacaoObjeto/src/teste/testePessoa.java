package teste;


public class testePessoa {

	public static void main(String[] args) {

	Pessoa p1 = new Pessoa("Pedro", 23);
	

	p1.peso = 65;
	p1.genero = "Não Binário";
	p1.alt = 1.69;
	
	System.out.println(p1.toString());
	System.out.println(p1.calculoImc());
	

	}

}
