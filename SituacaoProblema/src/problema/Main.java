package problema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	// Scanner e listas devem ser acessíveis por todos os métodos da classe
	private static Scanner sc = new Scanner(System.in);
	private static Biblioteca biblioteca = new Biblioteca();
	private static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {
		// Inicializa o sistema com dados pré-cadastrados
		carregarDadosIniciais();

		// Loop principal do menu
		while (true) {
			exibirMenuPrincipal();
			int opcao = -1;
			try {
				opcao = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Erro: Por favor, digite um número válido.");
				continue;
			}

			switch (opcao) {
			case 1:
				menuAdmin();
				break;
			case 2:
				menuLoginCadastro();
				break;
			case 0:
				System.out.println("Saindo do sistema. Até logo!");
				sc.close();
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	// Este método agora recebe o usuário que já fez login
	private static void menuUsuarioLogado(Usuario usuarioLogado) {
		while (true) {
			System.out.println("\n--- MENU DO USUÁRIO ---");
			System.out.println("1 - Listar Livros Disponíveis");
			System.out.println("2 - Emprestar um Livro");
			System.out.println("3 - Devolver um Livro");
			System.out.println("0 - Voltar (Logout)");
			System.out.print("Escolha sua opção: ");
			int opcao = Integer.parseInt(sc.nextLine());

			switch (opcao) {
			case 1:
				listarLivrosDisponiveis();
				break;
			case 2:
				System.out.print("Digite o código do livro que deseja emprestar: ");
				int codEmprestar = Integer.parseInt(sc.nextLine());
				biblioteca.emprestarLivro(usuarioLogado, codEmprestar);
				break;
			case 3:

				// 1. Lista os livros que o usuário pegou emprestado
				boolean temLivros = listarLivrosEmprestadosPeloUsuario(usuarioLogado);

				// 2. Só pede o código se o usuário tiver livros para devolver
				if (temLivros) {
					System.out.print("\nDigite o código do livro que deseja devolver: ");
					int codDevolver = Integer.parseInt(sc.nextLine());
					biblioteca.devolverLivro(usuarioLogado, codDevolver);
				}
				break;
			case 0:
				System.out.println("Fazendo logout...");
				return;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}

	private static boolean listarLivrosEmprestadosPeloUsuario(Usuario usuario) {
		System.out.println("\n--- SEUS LIVROS EMPRESTADOS ---");
		boolean temLivros = false;

		// Acessa a lista de empréstimos através do getter da biblioteca
		for (Emprestimo e : biblioteca.getEmprestimos()) {
			if (e.getUsuario().getId() == usuario.getId()) {
				Livro l = e.getLivro();
				System.out.println("Código: " + l.getCodig() + " | Título: " + l.getTitle() + " | Devolver até: "
						+ e.getDataDevolucao());
				temLivros = true;
			}
		}

		if (!temLivros) {
			System.out.println("Você não possui nenhum livro emprestado no momento.");
		}
		System.out.println("---------------------------------");
		return temLivros;
	}

	private static void carregarDadosIniciais() {
		// Cadastrando usuários iniciais
		usuarios.add(new Aluno(101, "Joao Silva", "joao.s@email.com"));
		usuarios.add(new Aluno(102, "Maria Oliveira", "maria.o@email.com"));
		usuarios.add(new Professor(201, "Dr. Carlos Souza", "carlos.souza@email.com"));
		usuarios.add(new Professor(202, "Dra. Ana Costa", "ana.costa@email.com"));

		biblioteca.getLivros().add(new Livro(1, "Java para Iniciantes", "Herbert Schildt", StatusLivro.DISPONIVEL));
		biblioteca.getLivros().add(new Livro(2, "Estruturas de Dados", "Thomas Cormen", StatusLivro.DISPONIVEL));
		biblioteca.getLivros().add(new Livro(3, "O Senhor dos Anéis", "J.R.R. Tolkien", StatusLivro.DISPONIVEL));
		biblioteca.getLivros().add(new Livro(4, "Inteligência Artificial", "Stuart Russell", StatusLivro.DISPONIVEL));

		System.out.println(">>> Bem-vindo ao Sistema da Biblioteca! <<<");
		System.out.println("Dados iniciais de usuários e livros carregados.\n");
	}

	private static void exibirMenuPrincipal() {
		System.out.println("\n--- MENU PRINCIPAL ---");
		System.out.println("1 - Acesso Administrativo");
		System.out.println("2 - Área de Usuário (Login / Cadastro)");
		System.out.println("0 - Sair");
		System.out.print("Escolha sua opção: ");
	}

	private static void menuLoginCadastro() {
		while (true) {
			System.out.println("\n--- ÁREA DE USUÁRIO ---");
			System.out.println("1 - Login");
			System.out.println("2 - Cadastrar novo usuário");
			System.out.println("0 - Voltar ao Menu Principal");
			System.out.print("Escolha sua opção: ");
			int opcao = Integer.parseInt(sc.nextLine());

			switch (opcao) {
			case 1:
				realizarLogin();
				break;
			case 2:
				cadastrarNovoUsuario();
				break;
			case 0:
				return;
			default:
				System.out.println("Opção inválida.");
			}
		}
	}

	private static void realizarLogin() {
		System.out.print("\nDigite seu ID de usuário: ");
		int id = Integer.parseInt(sc.nextLine());

		Usuario usuarioLogado = null;
		for (Usuario u : usuarios) {
			if (u.getId() == id) {
				usuarioLogado = u;
				break;
			}
		}

		if (usuarioLogado == null) {
			System.out.println("Login falhou. Usuário com ID " + id + " não encontrado!");
			return;
		}

		System.out.println("\nLogin bem-sucedido! Bem-vindo(a), " + usuarioLogado.getNome() + "!");
		menuUsuarioLogado(usuarioLogado); // Chama o menu de ações do usuário
	}

	private static void cadastrarNovoUsuario() {
		System.out.println("\n--- CADASTRO DE NOVO USUÁRIO ---");
		System.out.println("Você é (1) Aluno ou (2) Professor?");
		System.out.print("Escolha o tipo de usuário: ");
		int tipo = Integer.parseInt(sc.nextLine());

		if (tipo != 1 && tipo != 2) {
			System.out.println("Tipo inválido. Retornando ao menu anterior.");
			return;
		}

		System.out.print("Digite seu nome completo: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu e-mail: ");
		String email = sc.nextLine();

		int novoId = gerarNovoIdUsuario();

		if (tipo == 1) {
			usuarios.add(new Aluno(novoId, nome, email));
		} else { // tipo == 2
			usuarios.add(new Professor(novoId, nome, email));
		}

		System.out.println("\nCadastro realizado com sucesso!");
		System.out.println("Seu ID de acesso é: " + novoId + ". Anote para usar no login.");
	}

	private static int gerarNovoIdUsuario() {
		int maxId = 0;
		for (Usuario u : usuarios) {
			if (u.getId() > maxId) {
				maxId = u.getId();
			}
		}
		return maxId + 1; // Retorna o próximo ID disponível
	}

	private static void menuAdmin() {
		while (true) {
			System.out.println("\n--- MENU ADMINISTRATIVO ---");
			System.out.println("1 - Adicionar Novo Livro");
			System.out.println("2 - Listar Todos os Livros (Disponíveis e Emprestados)");
			System.out.println("0 - Voltar ao Menu Principal");
			System.out.print("Escolha sua opção: ");
			int opcao = Integer.parseInt(sc.nextLine());

			switch (opcao) {
			case 1:
				biblioteca.adicionarLivro();
				break;
			case 2:
				listarTodosOsLivros();
				break;
			case 0:
				return;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}

	private static void listarTodosOsLivros() {
		System.out.println("\n--- LISTA COMPLETA DE LIVROS ---");
		if (biblioteca.getLivros().isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
		} else {
			for (Livro l : biblioteca.getLivros()) {
				System.out.println("Código: " + l.getCodig() + " | Título: " + l.getTitle() + " | Autor: "
						+ l.getAutor() + " | Status: " + l.getStatus());
			}
		}
		System.out.println("---------------------------------");
	}

	private static void listarLivrosDisponiveis() {
		System.out.println("\n--- LIVROS DISPONÍVEIS PARA EMPRÉSTIMO ---");
		boolean algumDisponivel = false;
		for (Livro l : biblioteca.getLivros()) {
			if (l.getStatus() == StatusLivro.DISPONIVEL) {
				System.out.println(
						"Código: " + l.getCodig() + " | Título: " + l.getTitle() + " | Autor: " + l.getAutor());
				algumDisponivel = true;
			}
		}
		if (!algumDisponivel) {
			System.out.println("Nenhum livro disponível no momento.");
		}
		System.out.println("-------------------------------------------");
	}
}