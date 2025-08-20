package heranca;

public class Engenheiro extends Funcionario {
	private int NumCrea;

	public Engenheiro(String nome, String rg, double salario, int numCrea) {
		super(nome, rg, salario);
		NumCrea = numCrea;
	}

	public int getNumCrea() {
		return NumCrea;
	}

	public void setNumCrea(int numCrea) {
		NumCrea = numCrea;
	}
	
	
	
}
