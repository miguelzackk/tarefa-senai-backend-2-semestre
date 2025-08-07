package exerciciosGetSet;

import java.util.Scanner;

public class MainLivro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;

        
            Livro livro = new Livro();

            System.out.println("Bem-vindo ao sistema. Adicione seu livro no nosso banco de dados.");
            
            do {
            System.out.println("Digite o título do livro:");
            String titulo = sc.nextLine();
            livro.setTitulo(titulo);

            System.out.println("Digite o autor do livro:");
            String autor = sc.nextLine();
            livro.setAutor(autor);

            int numeroPaginas;
            do {
                System.out.println("Digite o número de páginas (não pode ser menor que 5):");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, digite um número válido:");
                    sc.next();
                }
                numeroPaginas = sc.nextInt();
                sc.nextLine();
                livro.setNumeroPaginas(numeroPaginas);
            } while (livro.getNumeroPaginas() < 5);

            System.out.println("\nLivro cadastrado com sucesso:");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Páginas: " + livro.getNumeroPaginas());

            System.out.println("\nMenu de opções: \n[0] - Sair \n[1] - Adicionar mais livros.");
            while (true) {
                if (sc.hasNextInt()) {
                    i = sc.nextInt();
                    sc.nextLine();
                    if (i == 0 || i == 1) {
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Opção inválida. Tente novamente: [0] - Sair. | [1] - Adicionar mais livros.");
            }

        } while (i == 1);

        sc.close();
        System.out.println("Encerrando o sistema.");
    }
}
