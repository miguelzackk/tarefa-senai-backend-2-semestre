package teste;

public class Pessoa {


	public String nome;
	public int idade;
	public int peso;
	public String genero;
	public double alt;
	
	
	
	public Pessoa(String nome, int idade, int peso, String genero, double alt) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.genero = genero;
		this.alt = alt;
	}
	
	public Pessoa (String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", peso=" + peso + ", genero=" + genero + "]";
	}
	
	public double calculoImc() {
		return peso / (alt * alt);
	}
	
	
	}

