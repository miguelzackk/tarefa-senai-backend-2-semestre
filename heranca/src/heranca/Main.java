package heranca;

public class Main {

	public static void main(String[] args) {
	
		Contador cont = new Contador("Danilo","564332592",2000,2343);
		
		System.out.println(cont.calculoSalario(2000));
		
		Eletricista elet = new Eletricista("Danilo", "dwadaw", 2000, false);
		System.out.println(elet.calculoSalario(2000));
		
	}
}
