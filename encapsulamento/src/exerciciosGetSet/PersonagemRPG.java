package exerciciosGetSet;

public class PersonagemRPG {
	private String nome;
	private String classe;
	private int nivel;
	private int vida;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		if (nivel < 1) {
			System.out.println("Erro: O nível não pode ser menor que 1.");
		} else {
			this.nivel = nivel;
		}
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida < 0) {
			this.vida = 0;
		} else if (vida > 100) {
			this.vida = 100;
		} else {
			this.vida = vida;
		}
	}

	public PersonagemRPG() {
		this.nivel = 1;
		this.vida = 100;
	}
}
