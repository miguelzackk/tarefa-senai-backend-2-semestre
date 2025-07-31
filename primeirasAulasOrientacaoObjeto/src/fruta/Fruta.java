package fruta;

public class Fruta {
	
	public String nome;
	public String cor;
	
	
	public Fruta(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}


	public Fruta() {
	}


	@Override
	public String toString() {
		return "Sua fruta é " + nome + " e a cor dela é " + cor + ".";
	}
		
	
}
