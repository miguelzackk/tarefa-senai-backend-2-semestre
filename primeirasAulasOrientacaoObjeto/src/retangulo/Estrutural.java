package retangulo;

import java.util.Scanner;

public class Estrutural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] larguras = new double[3];
        double[] alturas = new double[3];
        double[] areas = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Retângulo " + (i + 1) + ":");
            System.out.print("Digite a largura: ");
            larguras[i] = scanner.nextDouble();

            System.out.print("Digite a altura: ");
            alturas[i] = scanner.nextDouble();

            areas[i] = larguras[i] * alturas[i];
            System.out.println("Área do retângulo " + (i + 1) + ": " + areas[i]);
            System.out.println("-----------------------------");
        }

        scanner.close();
    }
}

