package heranca;

public class Main {

	public static void main(String[] args) {
	
		Engenheiro eng = new Engenheiro("Denis", "42517852X", 7000, 547821);
		
		System.out.println(eng.getNome());
		
		eng.setNome("Heitor");
		
		System.out.println(eng.getNome());

	}

}
