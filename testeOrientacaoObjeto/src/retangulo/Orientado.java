package retangulo;

	import java.util.Scanner;

	public class Orientado {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        Retangulo[] retangulos = new Retangulo[3];

	        for (int i = 0; i < 3; i++) {
	            System.out.println("Retângulo " + (i + 1) + ":");
	            System.out.print("Digite a largura: ");
	            double largura = scanner.nextDouble();

	            System.out.print("Digite a altura: ");
	            double altura = scanner.nextDouble();

	            retangulos[i] = new Retangulo(largura, altura);
	            System.out.println("Área do retângulo " + (i + 1) + ": " + retangulos[i].calcularArea());
	            System.out.println("-----------------------------");
	        }

	        scanner.close();
	    }
	}

