package heranca;

public class Eletricista extends Funcionario {

	private boolean nr10;

	public Eletricista(String nome, String rg, double salario, boolean nr10) {
		super(nome, rg, salario);
		this.setNr10(nr10);
	}
	
	@Override
	public double calculoSalario(double salario) {
		return salario = salario - 100 + 1000;
	}

	public boolean isNr10() {
		return nr10;
	}

	public void setNr10(boolean nr10) {
		this.nr10 = nr10;
	}

}
