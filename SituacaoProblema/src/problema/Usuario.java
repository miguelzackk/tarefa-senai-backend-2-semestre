package problema;

public abstract class Usuario {

	// inicializando variveis
	private int id;
	private String nome;
	private String email;

	// get, set e contrutor
	public Usuario(int id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// assinatura - método abstrato
	public abstract int getLimiteEmprestimos();

}
