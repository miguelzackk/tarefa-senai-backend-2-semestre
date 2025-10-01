package problema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	private List<Livro> livros;
	private List<Emprestimo> emprestimos;
	private Scanner sc;

	public Biblioteca() {
		livros = new ArrayList<>();
		emprestimos = new ArrayList<>();
		sc = new Scanner(System.in);
	}

	// adicionar livro digitando os dados
	public void adicionarLivro() {
		System.out.print("Código do livro: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		System.out.print("Título: ");
		String titulo = sc.nextLine();

		System.out.print("Autor: ");
		String autor = sc.nextLine();

		Livro l = new Livro(codigo, titulo, autor, null);
		livros.add(l);
		System.out.println("Livro adicionado: " + l.getTitle());
	}

	// emprestar livro passando objeto Usuario
	public void emprestarLivro(Usuario u, int codigo) {
		Livro livro = null;
		for (Livro l : livros) {
			if (l.getCodig() == codigo) {
				livro = l;
				break;
			}
		}

		if (livro == null) {
			System.out.println("Livro não encontrado!");
			return;
		}

		if (livro.getStatus() == StatusLivro.EMPRESTADO) {
			System.out.println("Livro indisponível!");
			return;
		}

		// conta quantos livros já pegou
		int emprestados = 0;
		for (Emprestimo e : emprestimos) {
			if (e.getUsuario().getId() == u.getId()) {
				emprestados++;
			}
		}

		if (emprestados >= u.getLimiteEmprestimos()) {
			System.out.println("Usuário " + u.getNome() + " já atingiu o limite de empréstimos!");
			return;
		}

		// realiza o empréstimo
		livro.setStatus(StatusLivro.EMPRESTADO);
		Emprestimo emp = new Emprestimo(livro, u);
		emprestimos.add(emp);
		System.out.println("Empréstimo realizado: " + emp);
	}

	// emprestar livro só pelo id do usuário
	public void emprestarLivro(List<Usuario> usuarios, int userId, int codigo) {
		Usuario u = null;
		for (Usuario user : usuarios) {
			if (user.getId() == userId) {
				u = user;
				break;
			}
		}

		if (u == null) {
			System.out.println("Usuário não encontrado!");
			return;
		}

		emprestarLivro(u, codigo);
	}

	// devolver livro
	public void devolverLivro(Usuario u, int codigo) {
		Emprestimo encontrado = null;

		for (Emprestimo e : emprestimos) {
			if (e.getUsuario().getId() == u.getId() && e.getLivro().getCodig() == codigo) {
				encontrado = e;
				break;
			}
		}

		if (encontrado == null) {
			System.out.println("Nenhum empréstimo encontrado para este usuário e livro!");
			return;
		}

		encontrado.getLivro().setStatus(StatusLivro.DISPONIVEL);
		emprestimos.remove(encontrado);
		System.out.println("Livro devolvido: " + encontrado.getLivro().getTitle());
	}
}
