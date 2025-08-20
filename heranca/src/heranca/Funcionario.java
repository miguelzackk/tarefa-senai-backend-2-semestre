package heranca;

public class Funcionario {
	
	private String nome;
	private String rg;
	private double salario;
	public Funcionario(String nome, String rg, double salario) {
		this.nome = nome;
		this.rg = rg;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public double getSalario() {
		return salario;
	}

	
	public double calculoSalario(double salario) {
		return salario =  salario - 100;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", rg=" + rg + ", salario=" + salario + "]";
	}
	
	
	
	
}