package problema;

//extendendo usuario para  usar seus métodos e atributos
public class Professor extends Usuario {

	// construtor
	public Professor(int id, String nome, String email) {
		super(id, nome, email);
	}

	// sobreescrevendo método
	@Override
	public int getLimiteEmprestimos() {
		return 5;
	}

}
