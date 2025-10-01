package problema;

//extendendo usuario para  usar seus métodos e atributos
public class Aluno extends Usuario {
	
	//construtor
	public Aluno(int id, String nome, String email) {
		super(id, nome, email);
	}

	//sobreescrevendo método
	@Override
	public int getLimiteEmprestimos() {
		return 2;
	}

}
