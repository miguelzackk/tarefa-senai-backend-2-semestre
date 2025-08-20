package anmaisHeranca;

public class Gato extends Animal {

	public Gato(String nome, String cor, double tamanho) {
		super(nome, cor, tamanho);
	}

	@Override
	public void fazerSom() {
		super.fazerSom();
		System.out.print("miau miau\n");
	}

}
